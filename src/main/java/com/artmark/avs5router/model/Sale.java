
package com.artmark.avs5router.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Sale complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Sale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="seatId" type="{}IDType" minOccurs="0"/>
 *         &lt;element name="ticketTypeId" type="{}IDType"/>
 *         &lt;element name="Passenger" type="{}Passenger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sale", propOrder = {
    "seatId",
    "ticketTypeId",
    "passenger"
})
public class Sale {

    protected String seatId;
    @XmlElement(required = true)
    protected String ticketTypeId;
    @XmlElement(name = "Passenger")
    protected Passenger passenger;

    /**
     * Gets the value of the seatId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatId() {
        return seatId;
    }

    /**
     * Sets the value of the seatId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatId(String value) {
        this.seatId = value;
    }

    /**
     * Gets the value of the ticketTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketTypeId() {
        return ticketTypeId;
    }

    /**
     * Sets the value of the ticketTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketTypeId(String value) {
        this.ticketTypeId = value;
    }

    /**
     * Gets the value of the passenger property.
     * 
     * @return
     *     possible object is
     *     {@link Passenger }
     *     
     */
    public Passenger getPassenger() {
        return passenger;
    }

    /**
     * Sets the value of the passenger property.
     * 
     * @param value
     *     allowed object is
     *     {@link Passenger }
     *     
     */
    public void setPassenger(Passenger value) {
        this.passenger = value;
    }

}
