
package com.artmark.avs5router.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="RouteKey" type="{}RouteKey"/>
 *         &lt;element name="ticketId" type="{}IDType" maxOccurs="unbounded"/>
 *         &lt;element name="Ticket" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ticketId" type="{}IDType"/>
 *                   &lt;element name="Passenger" type="{}Passenger" minOccurs="0"/>
 *                   &lt;element name="ticketSeries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ticketNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="relation" type="{}RelationType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Agent" type="{}Agent" minOccurs="0"/>
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
    "routeKey",
    "ticketId",
    "ticket",
    "agent"
})
@XmlRootElement(name = "TransitConfirmRequest")
public class TransitConfirmRequest {

    @XmlElement(name = "RouteKey", required = true)
    protected RouteKey routeKey;
    @XmlElement(required = true)
    protected List<String> ticketId;
    @XmlElement(name = "Ticket", required = true)
    protected List<TransitConfirmRequest.Ticket> ticket;
    @XmlElement(name = "Agent")
    protected Agent agent;

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
     * Gets the value of the ticketId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ticketId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTicketId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTicketId() {
        if (ticketId == null) {
            ticketId = new ArrayList<String>();
        }
        return this.ticketId;
    }

    /**
     * Gets the value of the ticket property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ticket property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTicket().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransitConfirmRequest.Ticket }
     * 
     * 
     */
    public List<TransitConfirmRequest.Ticket> getTicket() {
        if (ticket == null) {
            ticket = new ArrayList<TransitConfirmRequest.Ticket>();
        }
        return this.ticket;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ticketId" type="{}IDType"/>
     *         &lt;element name="Passenger" type="{}Passenger" minOccurs="0"/>
     *         &lt;element name="ticketSeries" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ticketNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="relation" type="{}RelationType" minOccurs="0"/>
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
        "ticketId",
        "passenger",
        "ticketSeries",
        "ticketNumber",
        "price",
        "relation"
    })
    public static class Ticket {

        @XmlElement(required = true)
        protected String ticketId;
        @XmlElement(name = "Passenger")
        protected Passenger passenger;
        @XmlElement(required = true)
        protected String ticketSeries;
        @XmlElement(required = true)
        protected String ticketNumber;
        @XmlElement(required = true)
        protected BigDecimal price;
        @XmlSchemaType(name = "string")
        protected RelationType relation;

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
         * Gets the value of the relation property.
         * 
         * @return
         *     possible object is
         *     {@link RelationType }
         *     
         */
        public RelationType getRelation() {
            return relation;
        }

        /**
         * Sets the value of the relation property.
         * 
         * @param value
         *     allowed object is
         *     {@link RelationType }
         *     
         */
        public void setRelation(RelationType value) {
            this.relation = value;
        }

    }

}
