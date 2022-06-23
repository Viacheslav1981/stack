package ru.sli.stack.utils;

public class Validations {
    public static boolean validateEmail(String email) {

        boolean ret = false;

        if (email == null) {
            throw new RuntimeException();
        }

        if (!email.contains("@")) {
            ret = false;
        }

        if (!email.contains(".")) {
            ret = false;
        }

        int indexAt = email.indexOf("@");
        int indexDot = email.indexOf(".");

        String[] arrayEmail = email.split("@");

        if ((indexAt < indexDot)
                && ((indexDot - indexAt) > 1)
                && (!email.endsWith("."))
                && (!email.startsWith("@"))
                && (!(arrayEmail.length > 2))) {
            ret = true;
        }

        return ret;
    }
}


