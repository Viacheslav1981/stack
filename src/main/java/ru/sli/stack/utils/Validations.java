package ru.sli.stack.utils;

public class Validations {
    public static boolean validateEmail(String email) {

        boolean ret = false;

        if (email == null) {
            throw new RuntimeException();
        }

        if ((email.contains("@")) && (email.contains("."))) {
            ret = true;
        }

        int indexAt = email.indexOf("@");
        int indexDot = email.indexOf(".");

        String[] arrayEmail = email.split("@");

        if (indexAt > indexDot) {
            ret = false;
        }

        if ((indexDot - indexAt) == 1) {
            ret = false;
        }

        if (email.endsWith(".")) {
            ret = false;
        }

        if (email.startsWith("@")) {
            ret = false;
        }

        if (arrayEmail.length > 2) {
            ret = false;
        }

        return ret;
    }
}


