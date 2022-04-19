package ru.sli.stack.controller;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
    private String field;
    private String errorText;
    private String message;
    private List<String> arrayErrorsFields = new ArrayList<>();


    public ValidationError(String field, String message) {
        this.message = message;
        setField(field);
        setErrorText(message);

    }


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}
