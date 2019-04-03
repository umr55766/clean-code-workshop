package com.thoughtworks.movierental;

public class HtmlUtils {
    final static String LINE_BREAK = "<br>";
    public static String getAsBold(String text) {
        return encloseWithTag("b", text);
    }

    public static String getAsBold(double text) {
        return encloseWithTag("b", text);
    }

    public static String getAsHeading(String text) {
        return encloseWithTag("h1", text);
    }

    private static String encloseWithTag(String tag, double text) {
        return "<" + tag + ">" + text + "</" + tag + ">";
    }

    private static String encloseWithTag(String tag, String text) {
        return "<" + tag + ">" + text + "</" + tag + ">";
    }
}
