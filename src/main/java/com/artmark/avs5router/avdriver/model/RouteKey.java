package com.artmark.avs5router.avdriver.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by nikolay on 23.10.17.
 */
public class RouteKey {
	@NotNull
	public String dispatchStationUid;
	@NotNull
	public String arrivalStationUid;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "HH:mm:ss")
	public Date dispatchTime;

}
