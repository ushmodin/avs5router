
package com.artmark.avs5router.sale.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="RouteKey" type="{}RouteKey"/>
 *           &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *           &lt;element name="dispatchStationUid" type="{}UidType"/>
 *           &lt;element name="arrivalStationUid" type="{}UidType"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "routeKey",
    "date",
    "dispatchStationUid",
    "arrivalStationUid"
})
@XmlRootElement(name = "GetFreeSeatsRequest")
public class GetFreeSeatsRequest {

    @XmlElement(name = "RouteKey")
    protected RouteKey routeKey;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    protected String dispatchStationUid;
    protected String arrivalStationUid;

    /**
     * Gets the value of the routeKey property.
     * 
     * @return
     *     possible object is
     *     {@link RouteKey }
     *     
     */
    public RouteKey getRouteKey() {
        return routeKey;
    }

    /**
     * Sets the value of the routeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteKey }
     *     
     */
    public void setRouteKey(RouteKey value) {
        this.routeKey = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the dispatchStationUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispatchStationUid() {
        return dispatchStationUid;
    }

    /**
     * Sets the value of the dispatchStationUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispatchStationUid(String value) {
        this.dispatchStationUid = value;
    }

    /**
     * Gets the value of the arrivalStationUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalStationUid() {
        return arrivalStationUid;
    }

    /**
     * Sets the value of the arrivalStationUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalStationUid(String value) {
        this.arrivalStationUid = value;
    }

}
