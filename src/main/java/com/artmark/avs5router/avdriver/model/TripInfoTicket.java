package com.artmark.avs5router.avdriver.model;


import java.math.BigDecimal;

/**
 * Created by nikolay on 23.10.17.
 */
public class TripInfoTicket {
	public String dispatchStationUid;
	public String dispatchStationName;
	public String arrivalStationUid;
	public String arrivalStationName;
	public Passenger passenger;
	public String ticketId;
	public String ticketSeries;
	public String ticketNumber;
	public int seatNum;
	public Agent agent;
	public BigDecimal price;

}
