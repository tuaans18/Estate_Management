package com.laptrinhjavaweb.builder;

import java.util.List;

public class BuildingSearchBuilder {

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


    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getWard() {
        return ward;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public String getDistrict() {
        return district;
    }

    public Long getStaffId() {
        return staffId;
    }

    public List<String> getTypes() {
        return types;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getDirection() {
        return direction;
    }

    public String getLevel() {
        return level;
    }

    public Integer getAreaFrom() {
        return areaFrom;
    }

    public Integer getAreaTo() {
        return areaTo;
    }

    public Integer getRentPriceFrom() {
        return rentPriceFrom;
    }

    public Integer getRentPriceTo() {
        return rentPriceTo;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public BuildingSearchBuilder(BuildingBuilder buildingBuilder){
        this.name = buildingBuilder.name;
        this.street = buildingBuilder.street;
        this.ward = buildingBuilder.ward;
        this.floorArea = buildingBuilder.floorArea;
        this.district = buildingBuilder.district;
        this.staffId = buildingBuilder.staffId;
        this.types = buildingBuilder.types;
        this.numberOfBasement = buildingBuilder.numberOfBasement;
        this.direction = buildingBuilder.direction;
        this.level = buildingBuilder.level;
        this.areaFrom = buildingBuilder.areaFrom;
        this.areaTo = buildingBuilder.areaTo;
        this.rentPriceFrom = buildingBuilder.rentPriceFrom;
        this.rentPriceTo = buildingBuilder.rentPriceTo;
        this.managerName = buildingBuilder.managerName;
        this.managerPhone = buildingBuilder.managerPhone;
    }

    public static class BuildingBuilder
    {
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

        public BuildingBuilder setName(String name){
            this.name = name;
            return this;
        }

        public BuildingBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public BuildingBuilder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public BuildingBuilder setFloorArea(Integer floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public BuildingBuilder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public BuildingBuilder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public BuildingBuilder setTypes(List<String> types) {
            this.types = types;
            return this;
        }

        public BuildingBuilder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public BuildingBuilder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public BuildingBuilder setLevel(String level) {
            this.level = level;
            return this;
        }

        public BuildingBuilder setAreaFrom(Integer areaFrom) {
            this.areaFrom = areaFrom;
            return this;
        }

        public BuildingBuilder setAreaTo(Integer areaTo) {
            this.areaTo = areaTo;
            return this;
        }

        public BuildingBuilder setRentPriceFrom(Integer rentPriceFrom) {
            this.rentPriceFrom = rentPriceFrom;
            return this;
        }

        public BuildingBuilder setRentPriceTo(Integer rentPriceTo) {
            this.rentPriceTo = rentPriceTo;
            return this;
        }

        public BuildingBuilder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public BuildingBuilder setManagerPhone(String managerPhone) {
            this.managerPhone = managerPhone;
            return this;
        }

        public BuildingSearchBuilder build() {
           return new BuildingSearchBuilder(this);
        }

    }
}
