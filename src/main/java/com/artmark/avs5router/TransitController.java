package com.artmark.avs5router;

import com.artmark.avs5router.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by nikolay on 19.03.17.
 */
@RestController
public class TransitController {
	private static final Logger log = LoggerFactory.getLogger(TransitController.class);
	@Autowired
	private TransitService transitService;

	@RequestMapping("/transit/book")
	public TransitBookResponse book(@RequestBody TransitBookRequest request) {
		return handleErrors(()->transitService.book(request), TransitBookResponse.class);
	}

	@RequestMapping("/transit/confirm")
	public TransitConfirmResponse confirm(@RequestBody TransitConfirmRequest request) {
		return handleErrors(()->transitService.confirm(request), TransitConfirmResponse.class);
	}

	@RequestMapping("/transit/cancel")
	public TransitCancelResponse cancel(@RequestBody TransitCancelRequest request) {
		return handleErrors(()->transitService.cancel(request), TransitCancelResponse.class);
	}

	@RequestMapping("/transit/getFreeSeats")
	public GetFreeSeatsResponse getFreeSeats(@RequestBody GetFreeSeatsRequest request) {
		return handleErrors(()->transitService.getFreeSeats(request), GetFreeSeatsResponse.class);
	}

	public <T extends AbstractResponse> T handleErrors(Supplier<T> action, Class<T> responseClass) {
		try {
			return action.get();
		} catch (Exception e) {
			log.error(null, e);
			T response = BeanUtils.instantiate(responseClass);
			AbstractResponse.Error error = new AbstractResponse.Error();
			error.setCode("UNKNOWN_ERROR");
			error.setMessage("Не известная ошибка. " + e.getMessage());
			response.setError(error);
			return response;
		}
	}
}
