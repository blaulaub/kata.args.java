package ch.patchcode.kata.args.it1;

import java.util.regex.Pattern;

public class Parameter {

    // refactoring hint: this constant has nothing to do with Parameter but all with
    // Parameter construction, so it probably fits better into a Parameter factory or builder
    public static final Pattern VALUE_TYPE_PATTERN = Pattern.compile("^\\(([^)]+)\\)$");

    private final String shortOptionLetter;
    private final String valueTypeLiteral;

    static Parameter fromSchemaPart(String schemaPart) {
        // refactoring hint: this lot of code that has nothing to do with Parameter but all with
        // Parameter construction, so it probably fits better into a Parameter factory or builder
        var shortOptionLetter = schemaPart.substring(0, 1);
        String remainder = schemaPart.substring(1);
        var matcher = VALUE_TYPE_PATTERN.matcher(remainder.length() > 0 ? remainder : "");
        String valueTypeLiteral = matcher.find() ? matcher.group(1) : "";
        return new Parameter(shortOptionLetter, valueTypeLiteral);
    }

    private Parameter(String shortOptionLetter, String valueTypeLiteral) {
        this.shortOptionLetter = shortOptionLetter;
        this.valueTypeLiteral = valueTypeLiteral;
    }

    public String shortOptionLetter() {
        return shortOptionLetter;
    }

    public boolean hasValue() {
        return valueTypeLiteral.length() > 0;
    }

    public String getValueTypeLiteral() {
        return valueTypeLiteral;
    }
}
