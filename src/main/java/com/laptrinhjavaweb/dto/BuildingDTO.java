package com.laptrinhjavaweb.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingDTO {
    private Long id;
    private String name;
    private String street;
    private String ward;
    private String district;
    private String structure;
    private List<String> types;
    private Integer numberOfBasement;
    private Integer floorArea;
    private String direction;
    private String level;
    private String rentArea;
    private Integer rentPrice;
    private String rentPriceDescription;
    private String serviceFee;
    private String carFee;
    private String motorbikeFee;
    private String overtimeFee;
    private String waterFee;
    private String electricityFee;
    private String deposit;
    private String payment;
    private String rentTime;
    private String decorationTime;
    private Float brokeRageFee;
    private String note;
    private Date createdDate;
    private Date modifiedDate;
    private Map<String,String> typeMaps = new HashMap<>();
    private Map<String,String> districtMaps = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getWard() {
        return ward;
    }
    public void setWard(String ward) {
        this.ward = ward;
    }
    public Integer getFloorArea() {
        return floorArea;
    }
    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }
    public String getStructure() {
        return structure;
    }
    public void setStructure(String structure) {
        this.structure = structure;
    }
    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }
    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public Integer getRentPrice() {
        return rentPrice;
    }
    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }
    public String getRentPriceDescription() {
        return rentPriceDescription;
    }
    public void setRentPriceDescription(String rentPriceDescription) {
        this.rentPriceDescription = rentPriceDescription;
    }
    public String getServiceFee() {
        return serviceFee;
    }
    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }
    public String getCarFee() {
        return carFee;
    }
    public void setCarFee(String carFee) {
        this.carFee = carFee;
    }
    public String getMotorbikeFee() {
        return motorbikeFee;
    }
    public void setMotorbikeFee(String motorbikeFee) {
        this.motorbikeFee = motorbikeFee;
    }
    public String getOvertimeFee() {
        return overtimeFee;
    }
    public void setOvertimeFee(String overtimeFee) {
        this.overtimeFee = overtimeFee;
    }
    public String getWaterFee() {
        return waterFee;
    }
    public void setWaterFee(String waterFee) {
        this.waterFee = waterFee;
    }
    public String getElectricityFee() {
        return electricityFee;
    }
    public void setElectricityFee(String electricityFee) {
        this.electricityFee = electricityFee;
    }
    public String getDeposit() {
        return deposit;
    }
    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }
    public String getPayment() {
        return payment;
    }
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public String getRentTime() {
        return rentTime;
    }
    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }
    public String getDecorationTime() {
        return decorationTime;
    }
    public void setDecorationTime(String decorationTime) {
        this.decorationTime = decorationTime;
    }
    public Float getBrokeRageFee() {
        return brokeRageFee;
    }
    public void setBrokeRageFee(Float brokeRageFee) {
        this.brokeRageFee = brokeRageFee;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getModifiedDate() {
        return modifiedDate;
    }
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public Map<String, String> getTypeMaps() {
        return typeMaps;
    }

    public void setTypeMaps(Map<String, String> typeMaps) {
        this.typeMaps = typeMaps;
    }

    public Map<String, String> getDistrictMaps() {
        return districtMaps;
    }

    public void setDistrictMaps(Map<String, String> districtMaps) {
        this.districtMaps = districtMaps;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }
}
