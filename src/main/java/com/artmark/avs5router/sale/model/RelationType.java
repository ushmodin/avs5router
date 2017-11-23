
package com.artmark.avs5router.sale.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RelationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OWN"/>
 *     &lt;enumeration value="AGENT"/>
 *     &lt;enumeration value="ATP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelationType")
@XmlEnum
public enum RelationType {

    OWN,
    AGENT,
    ATP;

    public String value() {
        return name();
    }

    public static RelationType fromValue(String v) {
        return valueOf(v);
    }

}
