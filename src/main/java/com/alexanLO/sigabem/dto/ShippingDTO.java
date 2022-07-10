package com.sigabem.sigabem.dto;

import com.sigabem.sigabem.entity.Shipping;
import java.io.Serializable;

public class ShippingDTO implements Serializable {

    private Long id;
    private Double productWeight;
    private Integer originZipCode;
    private Integer destinationZipCode;
    private String recipientName;

    public ShippingDTO() {
    }

    public ShippingDTO(Shipping shipping) {
       id = shipping.getId();
       productWeight = shipping.getProductWeight();
       originZipCode = shipping.getOriginZipCode();
       destinationZipCode = shipping.getDestinationZipCode();
       recipientName = shipping.getRecipientName();
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
}
