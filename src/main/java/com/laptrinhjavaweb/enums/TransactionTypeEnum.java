package com.laptrinhjavaweb.enums;

public enum TransactionTypeEnum {

    QT_CSKH("QUÁ TRÌNH CSKH"),
    DAN_DI_XEM("Dẫn đi xem");

    private final String trannsactionTypeValue;

    TransactionTypeEnum(String trannsactionTypeValue){
        this.trannsactionTypeValue = trannsactionTypeValue;
    }


    public String getTrannsactionTypeValue() {
        return trannsactionTypeValue;
    }
}
