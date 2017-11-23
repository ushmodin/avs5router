package com.artmark.avs5router.avdriver.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by nikolay on 23.11.17.
 */
public class UpdateTicketRequest {
	@NotNull
	public RouteKey routeKey;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date date;
	public String ticketId;
	public Boolean isGone;
}
