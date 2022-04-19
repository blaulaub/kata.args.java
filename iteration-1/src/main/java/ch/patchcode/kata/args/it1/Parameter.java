package ch.patchcode.kata.args.it1;

public class Parameter {
    private final String shortOptionLetter;
    private final String modifier;

    static Parameter fromParameter(String schemaPart) {
        var shortOptionLetter = schemaPart.substring(0, 1);
        var modifier = schemaPart.length() > 1 ? schemaPart.substring(1) : "";
        return new Parameter(shortOptionLetter, modifier);
    }

    private Parameter(String shortOptionLetter, String modifier) {
        this.shortOptionLetter = shortOptionLetter;
        this.modifier = modifier;
    }

    public String shortOptionLetter() {
        return shortOptionLetter;
    }
}
