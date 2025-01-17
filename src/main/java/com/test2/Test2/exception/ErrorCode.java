package com.test2.Test2.exception;


public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception."),
    INVALID_KEY(1001, "Invalid message key."),
    USER_EXISTED(1002, "User existed."),
    INVALID_USERNAME(1003, "Username must be at least 8 characters."),
    INVALID_PASSWORD(1004, "Password must be at least 8 characters.")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
