package com.sigabem.sigabem.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "shipping")
public class Shipping implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "product_weight")
    private Double productWeight;

    @Column(name = "origin_zip_code")
    private Integer originZipCode;

    @Column(name = "destination_zip_code")
    private Integer destinationZipCode;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "date")
    private Date date;

    //  “vlTotalFrete”, “dataPrevistaEntrega” e “dataConsulta”

    public Shipping() {
    }

    public Shipping(Long id, Double productWeight, Integer originZipCode, Integer destinationZipCode, String recipientName, Date date) {
        this.id = id;
        this.productWeight = productWeight;
        this.originZipCode = originZipCode;
        this.destinationZipCode = destinationZipCode;
        this.recipientName = recipientName;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(Double productWeight) {
        this.productWeight = productWeight;
    }

    public Integer getOriginZipCode() {
        return originZipCode;
    }

    public void setOriginZipCode(Integer originZipCode) {
        this.originZipCode = originZipCode;
    }

    public Integer getDestinationZipCode() {
        return destinationZipCode;
    }

    public void setDestinationZipCode(Integer destinationZipCode) {
        this.destinationZipCode = destinationZipCode;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipping shipping = (Shipping) o;
        return Objects.equals(id, shipping.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void updateInformation(Long id, Double weight, Integer zipOrigin, Integer zipDestination, String nameRecipient) {
        setId(id);
        setProductWeight(weight);
        setOriginZipCode(zipOrigin);
        setDestinationZipCode(zipDestination);
    }
}
