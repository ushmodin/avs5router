package com.artmark.avs5router.sale;

import com.artmark.avs5router.domain.model.Host;
import com.artmark.avs5router.router.HostService;
import com.artmark.avs5router.sale.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

/**
 * Created by nikolay on 20.03.17.
 */
@Service
public class TransitService {
	private final HostService hostService;

	public TransitService(HostService hostService) {
		this.hostService = hostService;
	}

	public TransitBookResponse book(TransitBookRequest request) {
		Host host = hostService.getHost(request.getRouteKey().getDispatchStationUid(), request.getRouteKey().getArrivalStationUid(), request.getRouteKey().getDispatchTime());
		return hostService.post(host, "/transit/book", request, TransitBookResponse.class, createError(TransitBookResponse.class));
	}

	public TransitConfirmResponse confirm(TransitConfirmRequest request) {
		Host host = hostService.getHost(request.getRouteKey().getDispatchStationUid(), request.getRouteKey().getArrivalStationUid(), request.getRouteKey().getDispatchTime());
		return hostService.post(host, "/transit/confirm", request, TransitConfirmResponse.class, createError(TransitConfirmResponse.class));
	}

	public TransitCancelResponse cancel(TransitCancelRequest request) {
		Host host = hostService.getHost(request.getRouteKey().getDispatchStationUid(), request.getRouteKey().getArrivalStationUid(), request.getRouteKey().getDispatchTime());
		return hostService.post(host, "/transit/cancel", request, TransitCancelResponse.class, createError(TransitCancelResponse.class));
	}

	public GetFreeSeatsResponse getFreeSeats(GetFreeSeatsRequest request) {
		Host host = hostService.getHost(request.getRouteKey().getDispatchStationUid(), request.getRouteKey().getArrivalStationUid(), request.getRouteKey().getDispatchTime());
		return hostService.post(host, "/transit/getFreeSeats", request, GetFreeSeatsResponse.class, createError(GetFreeSeatsResponse.class));
	}


	public TransitTripInfoResponse getTripInfo(TransitTripInfoRequest request) {
		Host host = hostService.getHost(request.getRouteKey().getDispatchStationUid(), request.getRouteKey().getArrivalStationUid(), request.getRouteKey().getDispatchTime());
		return hostService.post(host, "/transit/getTripInfo", request, TransitTripInfoResponse.class, createError(TransitTripInfoResponse.class));
	}

	public TransitRouteInfoResponse getRouteInfo(TransitRouteInfoRequest request) {
		Host host = hostService.getHost(request.getRouteKey().getDispatchStationUid(), request.getRouteKey().getArrivalStationUid(), request.getRouteKey().getDispatchTime());
		return hostService.post(host, "/transit/getRouteInfo", request, TransitRouteInfoResponse.class, createError(TransitRouteInfoResponse.class));
	}

	private static <T extends AbstractResponse> BiFunction<String, String, T> createError(Class<T> clazz) {
		return (code,message) -> {
			T instance = BeanUtils.instantiate(clazz);
			AbstractResponse.Error error = new AbstractResponse.Error();
			error.setCode(code);
			error.setMessage(message);
			instance.setError(error);
			return null;
		};
	}
}
