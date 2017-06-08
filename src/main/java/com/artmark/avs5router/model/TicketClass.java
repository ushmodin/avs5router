
package com.artmark.avs5router.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TicketClass.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TicketClass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PASSENGER"/>
 *     &lt;enumeration value="BAGGAGE"/>
 *     &lt;enumeration value="WITHOUT_SEAT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TicketClass")
@XmlEnum
public enum TicketClass {

    PASSENGER,
    BAGGAGE,
    WITHOUT_SEAT;

    public String value() {
        return name();
    }

    public static TicketClass fromValue(String v) {
        return valueOf(v);
    }

}
