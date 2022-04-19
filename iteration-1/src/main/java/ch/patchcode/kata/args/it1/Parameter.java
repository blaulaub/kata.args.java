package ch.patchcode.kata.args.it1;

public class Parameter {
    private final String shortOptionLetter;
    private final  String modifier;

    public Parameter(String shortOptionLetter, String modifier) {
        this.shortOptionLetter = shortOptionLetter;
        this.modifier = modifier;
    }

    public String shortOptionLetter() {
        return shortOptionLetter;
    }
}
