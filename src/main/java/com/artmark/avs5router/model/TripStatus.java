
package com.artmark.avs5router.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TripStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TripStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ON_SALE"/>
 *     &lt;enumeration value="SUSPENDED"/>
 *     &lt;enumeration value="CANCELED"/>
 *     &lt;enumeration value="DISPATCHED"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TripStatus")
@XmlEnum
public enum TripStatus {

    ON_SALE,
    SUSPENDED,
    CANCELED,
    DISPATCHED,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static TripStatus fromValue(String v) {
        return valueOf(v);
    }

}
