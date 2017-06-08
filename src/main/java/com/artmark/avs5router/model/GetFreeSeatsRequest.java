
package com.artmark.avs5router.model;

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
 *         &lt;sequence>
 *           &lt;element name="tripId" type="{}IDType"/>
 *           &lt;element name="dispatchStationId" type="{}IDType"/>
 *           &lt;element name="arrivalStationId" type="{}IDType"/>
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
    "arrivalStationUid",
    "tripId",
    "dispatchStationId",
    "arrivalStationId"
})
@XmlRootElement(name = "GetFreeSeatsRequest")
public class GetFreeSeatsRequest {

    @XmlElement(name = "RouteKey")
    protected RouteKey routeKey;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    protected String dispatchStationUid;
    protected String arrivalStationUid;
    protected String tripId;
    protected String dispatchStationId;
    protected String arrivalStationId;

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

    /**
     * Gets the value of the tripId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripId() {
        return tripId;
    }

    /**
     * Sets the value of the tripId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripId(String value) {
        this.tripId = value;
    }

    /**
     * Gets the value of the dispatchStationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispatchStationId() {
        return dispatchStationId;
    }

    /**
     * Sets the value of the dispatchStationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispatchStationId(String value) {
        this.dispatchStationId = value;
    }

    /**
     * Gets the value of the arrivalStationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalStationId() {
        return arrivalStationId;
    }

    /**
     * Sets the value of the arrivalStationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalStationId(String value) {
        this.arrivalStationId = value;
    }

}
