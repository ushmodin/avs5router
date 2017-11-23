
package com.artmark.avs5router.sale.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransitTicket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransitTicket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dispatchStationUid" type="{}UidType"/>
 *         &lt;element name="dispatchStationName" type="{}SimpleStringType"/>
 *         &lt;element name="arrivalStationUid" type="{}UidType"/>
 *         &lt;element name="arrivalStationName" type="{}SimpleStringType"/>
 *         &lt;element name="Passenger" type="{}Passenger"/>
 *         &lt;element name="ticketId" type="{}IDType"/>
 *         &lt;element name="ticketSeries" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="seatNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Agent" type="{}Agent"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="isGone" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransitTicket", propOrder = {
    "dispatchStationUid",
    "dispatchStationName",
    "arrivalStationUid",
    "arrivalStationName",
    "passenger",
    "ticketId",
    "ticketSeries",
    "ticketNumber",
    "seatNum",
    "agent",
    "price",
    "isGone"
})
public class TransitTicket {

    @XmlElement(required = true)
    protected String dispatchStationUid;
    @XmlElement(required = true)
    protected String dispatchStationName;
    @XmlElement(required = true)
    protected String arrivalStationUid;
    @XmlElement(required = true)
    protected String arrivalStationName;
    @XmlElement(name = "Passenger", required = true)
    protected Passenger passenger;
    @XmlElement(required = true)
    protected String ticketId;
    protected String ticketSeries;
    @XmlElement(required = true)
    protected String ticketNumber;
    protected int seatNum;
    @XmlElement(name = "Agent", required = true)
    protected Agent agent;
    @XmlElement(required = true)
    protected BigDecimal price;
    protected Boolean isGone;

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
     * Gets the value of the dispatchStationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispatchStationName() {
        return dispatchStationName;
    }

    /**
     * Sets the value of the dispatchStationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispatchStationName(String value) {
        this.dispatchStationName = value;
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
     * Gets the value of the arrivalStationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalStationName() {
        return arrivalStationName;
    }

    /**
     * Sets the value of the arrivalStationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalStationName(String value) {
        this.arrivalStationName = value;
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

    /**
     * Gets the value of the ticketId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * Sets the value of the ticketId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketId(String value) {
        this.ticketId = value;
    }

    /**
     * Gets the value of the ticketSeries property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketSeries() {
        return ticketSeries;
    }

    /**
     * Sets the value of the ticketSeries property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketSeries(String value) {
        this.ticketSeries = value;
    }

    /**
     * Gets the value of the ticketNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Sets the value of the ticketNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketNumber(String value) {
        this.ticketNumber = value;
    }

    /**
     * Gets the value of the seatNum property.
     * 
     */
    public int getSeatNum() {
        return seatNum;
    }

    /**
     * Sets the value of the seatNum property.
     * 
     */
    public void setSeatNum(int value) {
        this.seatNum = value;
    }

    /**
     * Gets the value of the agent property.
     * 
     * @return
     *     possible object is
     *     {@link Agent }
     *     
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * Sets the value of the agent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Agent }
     *     
     */
    public void setAgent(Agent value) {
        this.agent = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the isGone property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsGone() {
        return isGone;
    }

    /**
     * Sets the value of the isGone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsGone(Boolean value) {
        this.isGone = value;
    }

}
