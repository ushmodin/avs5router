package com.artmark.avs5router.avdriver;

import com.artmark.avs5router.avdriver.model.Response;
import com.artmark.avs5router.avdriver.model.TripInfoRequest;
import com.artmark.avs5router.avdriver.model.TripInfoResponse;
import com.artmark.avs5router.avdriver.model.UpdateTicketRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public Response<?> tripInfo(@RequestBody TripInfoRequest request) {
		return Response.success(service.tripInfo(request));
	}

	@RequestMapping("/api/avdriver/updateTicket")
	public Response<?> updateTicket(@RequestBody UpdateTicketRequest request) {
		service.updateTicket(request);
		return Response.success(null);
	}

	@RequestMapping("/api/avdriver/stations")
	public Response<?> getStations() {
		return Response.success(service.getStations());
	}



	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Response<?> exceptionHandler(Throwable e) {
		return Response.error("Ошибка сервиса", e.getMessage());
	}
}
