
package com.artmark.avs5router.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tripId" type="{}IDType"/>
 *         &lt;element name="dispatchStationId" type="{}IDType"/>
 *         &lt;element name="arrivalStationId" type="{}IDType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tripId",
    "dispatchStationId",
    "arrivalStationId"
})
@XmlRootElement(name = "GetTicketTypesRequest")
public class GetTicketTypesRequest {

    @XmlElement(required = true)
    protected String tripId;
    @XmlElement(required = true)
    protected String dispatchStationId;
    @XmlElement(required = true)
    protected String arrivalStationId;

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
