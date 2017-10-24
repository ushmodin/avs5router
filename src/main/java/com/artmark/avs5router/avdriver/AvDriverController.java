package com.artmark.avs5router.avdriver;

import com.artmark.avs5router.avdriver.model.TripInfoRequest;
import com.artmark.avs5router.avdriver.model.TripInfoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

/**
 * Created by nikolay on 23.10.17.
 */
@RestController
public class AvDriverController {

	@Autowired
	private AvDriverService service;

	@RequestMapping("/api/avdriver/tripInfo")
	public TripInfoResponse tripInfo(@RequestBody TripInfoRequest request) {
		return service.tripInfo(request);
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public HashMap<?,?> exceptionHandler(Throwable e) {
		HashMap<Object, Object> result = new HashMap<>();
		HashMap<Object, Object> error = new HashMap<>();
		error.put("message", "Ошибка сервиса");
		error.put("details", e.getMessage());
		result.put("error", error);
		return result;
	}
}
