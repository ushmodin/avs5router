package com.artmark.avs5router.router;

import com.artmark.avs5router.domain.HostRepository;
import com.artmark.avs5router.domain.model.Host;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.function.BiFunction;

/**
 * Created by nikolay on 23.11.17.
 */
@Service
public class HostService {
	private final HostRepository hostRepository;
	private final RestTemplateRepository restTemplateRepository;

	public HostService(HostRepository hostRepository, RestTemplateRepository restTemplateRepository) {
		this.hostRepository = hostRepository;
		this.restTemplateRepository = restTemplateRepository;
	}

	public Host getHost(String dispatchStationUid, String arrivalStationUid, XMLGregorianCalendar dispatchTime) {
		if ("1468886CD54D47A2869928363EB37A14".equals(dispatchStationUid)
				&& "932a8a0d-19c0-4582-a5a0-687df4a2870d".equals(arrivalStationUid)
				&& dispatchTime.getHour() == 15
				&& dispatchTime.getMinute() == 0) {
			return hostRepository.getOne(5226291L);
		}
		if ("932a8a0d-19c0-4582-a5a0-687df4a2870d".equals(dispatchStationUid)
				&& "1468886CD54D47A2869928363EB37A14".equals(arrivalStationUid)
				&& dispatchTime.getHour() == 9
				&& dispatchTime.getMinute() == 30) {
			return hostRepository.getOne(5226291L);
		}
		if ("29fe850c-9c37-45b4-95c3-42220600e09a".equals(dispatchStationUid)
				&& "36B109DE7B8B4218B1F13CCBE32BE4CC".equals(arrivalStationUid)
				&& dispatchTime.getHour() == 10
				&& dispatchTime.getMinute() == 0) {
			return hostRepository.getOne(7318722L);
		}

		return hostRepository.getHostByDepotUid(dispatchStationUid)
				.orElseThrow(()->new TransitException("Мастер-сервер не найден"));
	}

	public <T> T post(Host host, String uri, Object request, Class<T> responseClass, BiFunction<String, String, T> error) {
		try {
			return restTemplateRepository.getRestTemplate(host).postForObject(uri, request, responseClass);
		} catch (RestClientException e) {
			Throwable cause = e.getCause();
			if (cause instanceof ConnectException) {
				return error.apply("IO_ERROR", "Не удалось подключиться к мастер-серверу автовокзала.");
			} else if (cause instanceof SocketTimeoutException) {
				return error.apply("IO_ERROR", "Мастер-сервер автовокзала не ответил вовремя.");
			} else if (cause instanceof IOException) {
				return error.apply("IO_ERROR", "Не известная сетевая ошибка.");
			}
			throw e;
		} catch (HttpMessageNotReadableException e) {
			return error.apply("CONTENT_ERROR", "Не удалось разобрать ответ от мастер-сервера.");
		}
	}

}
