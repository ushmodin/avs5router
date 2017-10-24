package com.artmark.avs5router.avdriver.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by nikolay on 23.10.17.
 */
public class TripInfoStop {
	public String name;
	public String uid;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	public Date dispatchTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	public Date arrivalTime;
	public List<TripInfoTicket> in;
	public List<TripInfoTicket> out;
	public int order;
}
