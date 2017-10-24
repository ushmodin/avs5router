package com.artmark.avs5router.avdriver.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by nikolay on 23.10.17.
 */
public class TripInfoResponse {
	public String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	public Date date;
	public List<TripInfoStop> stops;
	public Carrier carrier;
	public int maxSeats;
}
