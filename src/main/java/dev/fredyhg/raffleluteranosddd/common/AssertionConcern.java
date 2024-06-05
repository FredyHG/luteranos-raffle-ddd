package dev.fredyhg.raffleluteranosddd.common;

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
}
