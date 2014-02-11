package com.sourceclear.headlines.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class HeaderBuilder {

    private HeaderBuilder() {

    }

    public static String formatDirectives(ImmutableMap<String, ImmutableList<String>> directives) {

        // In the case of an empty map return the empty string:
        if (directives.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        // Outer loop - loop through each directive
        for (String directive : directives.keySet()) {

            // Don't add a directive if it has zero elements
            if (directives.get(directive).size() == 0) {
                continue;
            }

            StringBuilder elements = new StringBuilder();

            // Inner loop = for each directive build up the element String
            for (String element : directives.get(directive)) {
                elements.append(element).append(" ");
            }

            if (sb.length() > 0) {
                sb.append("; ");
            }

            sb.append(directive).append(" ").append(elements.append(" ").toString());
        }

        return sb.toString().trim();
    }

    /**
     * @param values - list of String attribute values
     * @return formatted values
     */
    public static String formatListAttributeValues(ImmutableList<String> values) {

        // In the case of an empty map return the empty string:
        if (values.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        // Outer loop - loop through each directive
        for (int i = 0; i < values.size(); i++) {

            // Don't add a directive if it has zero elements
            if (values.size() == 0) {
                continue;
            }

            //adding value of header attributes
            sb.append("'").append(values.get(i)).append("'");

            // adding comma if list value isn't last
            if (values.size() > 1 && i < values.size() - 1) {
                sb.append(",");
            }
        }

        return sb.toString().trim();
    }

}
