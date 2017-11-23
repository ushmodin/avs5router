package com.artmark.avs5router.dispatcher;

import com.artmark.avs5router.dispatcher.model.AbstractResponse;
import com.artmark.avs5router.dispatcher.model.RouteKey;
import com.artmark.avs5router.dispatcher.model.UpdateTicketRequest;
import com.artmark.avs5router.dispatcher.model.UpdateTicketResponse;
import com.artmark.avs5router.domain.model.Host;
import com.artmark.avs5router.router.HostService;
import com.artmark.avs5router.util.Dates;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.BiFunction;

/**
 * Created by nikolay on 23.11.17.
 */
@Service
public class DispatcherService {
	private final HostService hostService;

	public DispatcherService(HostService hostService) {
		this.hostService = hostService;
	}

	public UpdateTicketResponse updateTicket(RouteKey routeKey, Date date, String ticketId, Boolean isGone) {
		Host host = hostService.getHost(routeKey.getDispatchStationUid(), routeKey.getArrivalStationUid(), routeKey.getDispatchTime());
		UpdateTicketRequest request = new UpdateTicketRequest();
		request.setRouteKey(routeKey);
		request.setDate(Dates.toXmlDate(date));
		request.setTicketId(ticketId);
		request.setIsGone(isGone);

		return hostService.post(host, "/dispatcher/updateTicket", request, UpdateTicketResponse.class, createError(UpdateTicketResponse.class));
	}

	private static <T extends AbstractResponse> BiFunction<String, String, T> createError(Class<T> clazz) {
		return (code, message) -> {
			T instance = BeanUtils.instantiate(clazz);
			AbstractResponse.Error error = new AbstractResponse.Error();
			error.setCode(code);
			error.setMessage(message);
			instance.setError(error);
			return null;
		};
	}
}
