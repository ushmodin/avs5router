package com.artmark.avs5router.avdriver;

import com.artmark.avs5router.avdriver.model.Agent;
import com.artmark.avs5router.avdriver.model.*;
import com.artmark.avs5router.avdriver.model.Passenger;
import com.artmark.avs5router.avdriver.model.RouteKey;
import com.artmark.avs5router.dispatcher.DispatcherService;
import com.artmark.avs5router.domain.GlobalStationRepository;
import com.artmark.avs5router.sale.model.*;
import com.artmark.avs5router.sale.TransitService;
import com.artmark.avs5router.util.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by nikolay on 23.10.17.
 */
@Service
public class AvDriverService {

	@Autowired
	private TransitService transitService;
	@Autowired
	private DispatcherService dispatcherService;
	@Autowired
	private GlobalStationRepository globalStationRepository;

	public TripInfoResponse tripInfo(TripInfoRequest request) {
		TransitTripInfoResponse.Body tripInfoBody = getTripInfo(request);
		List<TripInfoTicket> tickets = tripInfoBody.getTicket().stream().map(it -> createTripInfoTicket(it)).collect(Collectors.toList());
		Map<String, List<TripInfoTicket>> groupByDispSt = tickets
				.stream()
				.collect(Collectors.groupingBy(it -> it.dispatchStationUid))
				.entrySet()
				.stream()
				.peek(it->it.getValue().sort(Comparator.comparingInt(a -> a.seatNum)))
				.collect(Collectors.toMap(it->it.getKey(), it->it.getValue()));

		Map<String, List<TripInfoTicket>> groupByArrivSt = tickets
				.stream()
				.collect(Collectors.groupingBy(it -> it.arrivalStationUid))
				.entrySet()
				.stream()
				.peek(it->it.getValue().sort(Comparator.comparingInt(a -> a.seatNum)))
				.collect(Collectors.toMap(it->it.getKey(), it->it.getValue()));



		TransitRouteInfoResponse.Body routeInfoBody = getRouteInfo(request);
		List<TripInfoStop> stops = routeInfoBody.getRouteItem().stream().map(it -> createTripInfoStop(it)).collect(Collectors.toList());

		stops.forEach(it->{
			it.in = groupByDispSt.get(it.uid);
			it.out = groupByArrivSt.get(it.uid);
		});

		TripInfoResponse result = new TripInfoResponse();
		result.name = routeInfoBody.getName();
		result.maxSeats = tripInfoBody.getMaxSeats();
		result.stops = stops;
		if (tripInfoBody.getCarrier() != null) {
			result.carrier = new Carrier();
			result.carrier.inn = tripInfoBody.getCarrier().getInn();
			result.carrier.name = tripInfoBody.getCarrier().getName();
		}
		return result;
	}

	private TransitRouteInfoResponse.Body getRouteInfo(TripInfoRequest request) {
		TransitRouteInfoRequest routeInfoRequest = new TransitRouteInfoRequest();
		routeInfoRequest.setRouteKey(createRouteKey(request.routeKey));
		TransitRouteInfoResponse routeInfo = transitService.getRouteInfo(routeInfoRequest);
		if (routeInfo.getError() != null) {
			throw new RemoteException(routeInfo.getError().getCode(), routeInfo.getError().getMessage());
		}
		return routeInfo.getBody();
	}

	private com.artmark.avs5router.sale.model.RouteKey createRouteKey(RouteKey routeKey) {
		com.artmark.avs5router.sale.model.RouteKey result = new com.artmark.avs5router.sale.model.RouteKey();
		result.setArrivalStationUid(routeKey.arrivalStationUid);
		result.setDispatchStationUid(routeKey.dispatchStationUid);
		result.setDispatchTime(Dates.toXmlTime(routeKey.dispatchTime));
		return result;
	}

	private TransitTripInfoResponse.Body getTripInfo(TripInfoRequest request) {
		TransitTripInfoRequest tripInfoRequest = new TransitTripInfoRequest();
		tripInfoRequest.setDate(Dates.toXmlDate(request.date));
		tripInfoRequest.setRouteKey(createRouteKey(request.routeKey));
		TransitTripInfoResponse tripInfo = transitService.getTripInfo(tripInfoRequest);
		if (tripInfo.getError() != null) {
			throw new RemoteException(tripInfo.getError().getCode(), tripInfo.getError().getMessage());
		}
		return tripInfo.getBody();
	}

	private TripInfoStop createTripInfoStop(RouteItem it) {
		TripInfoStop result = new TripInfoStop();
		result.arrivalTime = Dates.toDate(it.getArrivalTime());
		result.dispatchTime = Dates.toDate(it.getDispatchTime());
		result.name = it.getStationName();
		result.uid = it.getStationUid();
		result.order = it.getOrder();
		return result;
	}

	private TripInfoTicket createTripInfoTicket(TransitTicket it) {
		TripInfoTicket result = new TripInfoTicket();
		result.seatNum = it.getSeatNum();
		result.arrivalStationName = it.getArrivalStationName();
		result.arrivalStationUid = it.getArrivalStationUid();
		result.dispatchStationName = it.getDispatchStationName();
		result.dispatchStationUid = it.getDispatchStationUid();
		result.price = it.getPrice();
		result.ticketId = it.getTicketId();
		result.ticketSeries = it.getTicketSeries();
		result.ticketNumber = it.getTicketNumber();
		result.isGone = it.isIsGone();

		if (it.getPassenger() != null) {
			result.passenger = new Passenger();
			com.artmark.avs5router.sale.model.Passenger passenger = it.getPassenger();

			result.passenger.birthday = Dates.toDate(passenger.getBirthday());
			result.passenger.citizenshipISO2 = passenger.getCitizenshipISO2();
			result.passenger.docNum = passenger.getDocNum();
			result.passenger.docSeries = passenger.getDocSeries();
			result.passenger.docTypeId = passenger.getDocTypeId();
			result.passenger.firstName = passenger.getFirstName();
			result.passenger.lastName = passenger.getLastName();
			result.passenger.middleName = passenger.getMiddleName();
			result.passenger.gender = passenger.getGender() != null ? passenger.getGender().value() : "";
			result.passenger.info = passenger.getInfo();
			result.passenger.phone = passenger.getPhone();
		}

		if (it.getAgent() != null) {
			result.agent = new Agent();
			result.agent.inn = it.getAgent().getInn();
			result.agent.name = it.getAgent().getName();
		}
		return result;
	}

	public void updateTicket(UpdateTicketRequest request) {
		dispatcherService.updateTicket(getRouteKey(request.routeKey), request.date, request.ticketId, request.isGone);
	}

	private static com.artmark.avs5router.dispatcher.model.RouteKey getRouteKey(RouteKey routeKey) {
		com.artmark.avs5router.dispatcher.model.RouteKey result = new com.artmark.avs5router.dispatcher.model.RouteKey();
		result.setDispatchStationUid(routeKey.dispatchStationUid);
		result.setArrivalStationUid(routeKey.arrivalStationUid);
		result.setDispatchTime(Dates.toXmlTime(routeKey.dispatchTime));
		return result;
	}

	public List<Station> getStations() {
		return globalStationRepository.findAll(new Sort("name")).stream().map(it -> {
			Station station = new Station();
			station.name = it.getName();
			station.guid = it.getGuid();
			return station;
		}).collect(Collectors.toList());
	}
}
