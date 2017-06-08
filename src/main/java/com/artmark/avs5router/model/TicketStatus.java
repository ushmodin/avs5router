
package com.artmark.avs5router.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TicketStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TicketStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RESERVED"/>
 *     &lt;enumeration value="SOLD"/>
 *     &lt;enumeration value="CANCELED"/>
 *     &lt;enumeration value="RETURNED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TicketStatus")
@XmlEnum
public enum TicketStatus {

    RESERVED,
    SOLD,
    CANCELED,
    RETURNED;

    public String value() {
        return name();
    }

    public static TicketStatus fromValue(String v) {
        return valueOf(v);
    }

}
