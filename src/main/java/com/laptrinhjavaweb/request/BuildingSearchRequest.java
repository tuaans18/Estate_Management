package com.laptrinhjavaweb.request;

import java.util.List;

public class BuildingSearchRequest {

    private String name;
    private String street;
    private String ward;
    private Integer floorArea;
    private String district;
    private Long staffId;
    private List<String> types;
    private Integer numberOfBasement;
    private String direction;
    private String level;
    private Integer areaFrom;
    private Integer areaTo;
    private Integer rentPriceFrom;
    private Integer rentPriceTo;
    private String managerName;
    private String managerPhone;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getAreaFrom() {
        return areaFrom;
    }

    public void setAreaFrom(Integer areaFrom) {
        this.areaFrom = areaFrom;
    }

    public Integer getAreaTo() {
        return areaTo;
    }

    public void setAreaTo(Integer areaTo) {
        this.areaTo = areaTo;
    }

    public Integer getRentPriceFrom() {
        return rentPriceFrom;
    }

    public void setRentPriceFrom(Integer rentPriceFrom) {
        this.rentPriceFrom = rentPriceFrom;
    }

    public Integer getRentPriceTo() {
        return rentPriceTo;
    }

    public void setRentPriceTo(Integer rentPriceTo) {
        this.rentPriceTo = rentPriceTo;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
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

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
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
}
