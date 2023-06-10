package com.laptrinhjavaweb.enums;

public enum SpecialSearchParamsEnum {

    DISTRICT("district"),
    STAFF_ID("staffId"),
    RENT_PRICE_FROM("rentPriceFrom"),
    RENT_PRICE_TO("rentPriceTo"),
    RENT_AREA_FROM("areaFrom"),
    RENT_AREA_TO("areaTo");

    private final String value;

    SpecialSearchParamsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
