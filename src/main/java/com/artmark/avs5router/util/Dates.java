package com.artmark.avs5router.util;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by nikolay on 23.10.17.
 */
public class Dates {
	public static XMLGregorianCalendar toXmlDate(Date date) {
		if (date == null) {
			return null;
		}
		try {
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(date);
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
			xmlGregorianCalendar.setSecond(DatatypeConstants.FIELD_UNDEFINED);
			xmlGregorianCalendar.setMinute(DatatypeConstants.FIELD_UNDEFINED);
			xmlGregorianCalendar.setHour(DatatypeConstants.FIELD_UNDEFINED);
			return xmlGregorianCalendar;
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
	}
	public static XMLGregorianCalendar toXmlDateTime(Date date) {
		if (date == null) {
			return null;
		}
		try {
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(date);
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
			return xmlGregorianCalendar;
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

	public static XMLGregorianCalendar toXmlTime(Date date) {
		if (date == null) {
			return null;
		}
		try {
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(date);
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
			xmlGregorianCalendar.setYear(DatatypeConstants.FIELD_UNDEFINED);
			xmlGregorianCalendar.setMonth(DatatypeConstants.FIELD_UNDEFINED);
			xmlGregorianCalendar.setDay(DatatypeConstants.FIELD_UNDEFINED);
			return xmlGregorianCalendar;
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

	public static Date toDate(XMLGregorianCalendar date) {
		if (date == null) {
			return null;
		}
		return date.toGregorianCalendar().getTime();
	}
}
