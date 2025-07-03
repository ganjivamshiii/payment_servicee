package com.hulkhiretech.payments.constant;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    GENERIC_ERROR("10000", "Unable to process your request, please try later"),
    MISSING_CUSTOMER_ID("10001", "Customer ID is missing in the payment request");

    private final String errorCode;
    private final String errorMessage;

    ErrorEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}

