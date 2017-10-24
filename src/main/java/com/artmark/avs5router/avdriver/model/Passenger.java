package com.artmark.avs5router.avdriver.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by nikolay on 23.10.17.
 */
public class Passenger {
	public String firstName;
	public String lastName;
	public String middleName;
	public String docNum;
	public String docSeries;
	public String docTypeId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date birthday;
	public String citizenshipISO2;
	public String gender;
	public String phone;
	public String info;

}
