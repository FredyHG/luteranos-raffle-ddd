package dev.fredyhg.raffleluteranosddd.common;

import java.util.List;
import java.util.regex.Pattern;

public class AssertionConcern {
    private AssertionConcern() {
        super();
    }

    public static void assertArgumentNotEmpty(String aString, String aMessage) {
        if (aString == null || aString.trim().isEmpty()) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public static void assertArgumentNotNull(Object anObject, String aMessage) {
        if (anObject == null) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public static void assertArgumentMinLength(String aString, int aMinimum, String aMessage) {
        int length = aString.trim().length();
        if (length < aMinimum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public static void assertArgumentMinSize(List aList, int aMinimum, String aMessage) {
        if (aList == null || aList.size() < aMinimum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public static void assertArgumentIsEmail(String aString, String aMessage) {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        boolean isEmail = pattern.matcher(aString).find();

        if (!isEmail) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public static void assertArgumentIsCPF(String aString, String aMessage) {
        Pattern pattern = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");
        boolean isCPF = pattern.matcher(aString).find();

        if (!isCPF) {
            throw new IllegalArgumentException(aMessage);
        }
    }
}
