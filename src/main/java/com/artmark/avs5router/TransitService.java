package com.artmark.avs5router;

import com.artmark.avs5router.domain.HostRepository;
import com.artmark.avs5router.domain.model.Host;
import com.artmark.avs5router.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.function.Supplier;

/**
 * Created by nikolay on 20.03.17.
 */
@Service
public class TransitService {
	private final HostRepository hostRepository;
	private final RestTemplateRepository restTemplateRepository;
	private final static Logger log = LoggerFactory.getLogger(TransitService.class);

	public TransitService(HostRepository hostRepository, RestTemplateRepository restTemplateRepository) {
		this.hostRepository = hostRepository;
		this.restTemplateRepository = restTemplateRepository;
	}


	public TransitBookResponse book(TransitBookRequest request) {
		Host host = getHost(request.getRouteKey());
		return post(host, "/transit/book", request, TransitBookResponse.class);
	}

	public TransitConfirmResponse confirm(TransitConfirmRequest request) {
		Host host = getHost(request.getRouteKey());
		return post(host, "/transit/confirm", request, TransitConfirmResponse.class);
	}

	public TransitCancelResponse cancel(TransitCancelRequest request) {
		Host host = getHost(request.getRouteKey());
		return post(host, "/transit/cancel", request, TransitCancelResponse.class);
	}

	public GetFreeSeatsResponse getFreeSeats(GetFreeSeatsRequest request) {
		Host host = getHost(request.getRouteKey());
		return post(host, "/transit/getFreeSeats", request, GetFreeSeatsResponse.class);
	}

	private Host getHost(RouteKey routeKey) {
		if ("1468886CD54D47A2869928363EB37A14".equals(routeKey.getDispatchStationUid())
			&& "932a8a0d-19c0-4582-a5a0-687df4a2870d".equals(routeKey.getArrivalStationUid())
			&& routeKey.getDispatchTime().getHour() == 15
			&& routeKey.getDispatchTime().getMinute() == 0) {
			return hostRepository.getOne(5226291L);
		}
		if ("932a8a0d-19c0-4582-a5a0-687df4a2870d".equals(routeKey.getDispatchStationUid())
			&& "1468886CD54D47A2869928363EB37A14".equals(routeKey.getArrivalStationUid())
			&& routeKey.getDispatchTime().getHour() == 9
			&& routeKey.getDispatchTime().getMinute() == 30) {
			return hostRepository.getOne(5226291L);
		}
		if ("29fe850c-9c37-45b4-95c3-42220600e09a".equals(routeKey.getDispatchStationUid())
				&& "36B109DE7B8B4218B1F13CCBE32BE4CC".equals(routeKey.getArrivalStationUid())
				&& routeKey.getDispatchTime().getHour() == 10
				&& routeKey.getDispatchTime().getMinute() == 0) {
			return hostRepository.getOne(7318722L);
		}

		return hostRepository.getHostByDepotUid(routeKey.getDispatchStationUid())
				.orElseThrow(()->new TransitException("Мастер-сервер не найден"));
	}

	private <T extends AbstractResponse> T post(Host host, String uri, Object request, Class<T> responseClass) {
		try {
			return restTemplateRepository.getRestTemplate(host).postForObject(uri, request, responseClass);
		} catch (RestClientException e) {
			Throwable cause = e.getCause();
			if (cause instanceof ConnectException) {
				T response = BeanUtils.instantiate(responseClass);
				AbstractResponse.Error error = new AbstractResponse.Error();
				error.setCode("IO_ERROR");
				error.setMessage("Не удалось подключиться к мастер-серверу автовокзала.");
				response.setError(error);
				return response;
			} else if (cause instanceof SocketTimeoutException) {
				T response = BeanUtils.instantiate(responseClass);
				AbstractResponse.Error error = new AbstractResponse.Error();
				error.setCode("IO_ERROR");
				error.setMessage("Мастер-сервер автовокзала не ответил вовремя.");
				response.setError(error);
				return response;
			} else if (cause instanceof IOException) {
				T response = BeanUtils.instantiate(responseClass);
				AbstractResponse.Error error = new AbstractResponse.Error();
				error.setCode("IO_ERROR");
				error.setMessage("Не известная сетевая ошибка.");
				response.setError(error);
				return response;
			}
			throw e;
		} catch (HttpMessageNotReadableException e) {
			T response = BeanUtils.instantiate(responseClass);
			AbstractResponse.Error error = new AbstractResponse.Error();
			error.setCode("CONTENT_ERROR");
			error.setMessage("Не удалось разобрать ответ от мастер-сервера.");
			response.setError(error);
			return response;
		}
	}
}
