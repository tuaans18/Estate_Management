package com.laptrinhjavaweb.response;

public class BuildingSearchRespone {
    private Long id;
    private String name;
    private String address;
    private Integer floorArea;
    private String rentPriceDescription;
    private Integer rentPrice;
    private String serviceFee;
    private Float brokerageFee;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getFloorArea() {
        return floorArea;
    }
    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }
    public String getRentPriceDescription() {
        return rentPriceDescription;
    }
    public void setRentPriceDescription(String rentPriceDescription) {
        this.rentPriceDescription = rentPriceDescription;
    }
    public Integer getRentPrice() {
        return rentPrice;
    }
    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }
    public String getServiceFee() {
        return serviceFee;
    }
    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }
    public Float getBrokerageFee() {
        return brokerageFee;
    }
    public void setBrokerageFee(Float brokerageFee) {
        this.brokerageFee = brokerageFee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
