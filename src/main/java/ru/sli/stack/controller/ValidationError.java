package ru.sli.stack.controller;

public class ValidationError {
    private String field;
    private String errorText;
    private String message;

    public ValidationError(String field, String message) {
        this.message = message;
        setField(field);
        setErrorText(message);
        // setField("title");
        //  setErrorText("testMessage");
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
