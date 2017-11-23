
package com.artmark.avs5router.sale.model;

import java.util.ArrayList;
import java.util.List;
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
 *       &lt;sequence>
 *         &lt;element name="RouteKey" type="{}RouteKey"/>
 *         &lt;element name="dispatchStationUid" type="{}UidType"/>
 *         &lt;element name="arrivalStationUid" type="{}UidType"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="seatId" type="{}IDType" maxOccurs="unbounded"/>
 *         &lt;element name="Agent" type="{}Agent"/>
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
    "dispatchStationUid",
    "arrivalStationUid",
    "date",
    "seatId",
    "agent"
})
@XmlRootElement(name = "TransitBookRequest")
public class TransitBookRequest {

    @XmlElement(name = "RouteKey", required = true)
    protected RouteKey routeKey;
    @XmlElement(required = true)
    protected String dispatchStationUid;
    @XmlElement(required = true)
    protected String arrivalStationUid;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(required = true)
    protected List<String> seatId;
    @XmlElement(name = "Agent", required = true)
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
     * Gets the value of the seatId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the seatId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSeatId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSeatId() {
        if (seatId == null) {
            seatId = new ArrayList<String>();
        }
        return this.seatId;
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

}
