package ch.patchcode.kata.args.it1;

import java.util.regex.Pattern;

public class Parameter {
    private final String shortOptionLetter;
    private final String modifier;
    private final String valueTypeLiteral;

    static Parameter fromSchemaPart(String schemaPart) {
        var shortOptionLetter = schemaPart.substring(0, 1);
        String remainder = schemaPart.substring(1);
        var modifier = remainder.length() > 0 ? remainder : "";
        var pattern = Pattern.compile("^\\(([^)]+)\\)$");
        var matcher = pattern.matcher(modifier);
        String valueTypeLiteral = matcher.find() ? matcher.group(1) : "";
        return new Parameter(shortOptionLetter, modifier, valueTypeLiteral);
    }

    private Parameter(String shortOptionLetter, String modifier, String valueTypeLiteral) {
        this.shortOptionLetter = shortOptionLetter;
        this.modifier = modifier;
        this.valueTypeLiteral = valueTypeLiteral;
    }

    public String shortOptionLetter() {
        return shortOptionLetter;
    }

    public boolean hasValue() {
        return modifier.length() > 0;
    }

    public String getValueTypeLiteral() {
        return valueTypeLiteral;
    }
}
