package ch.patchcode.kata.args.it1;

public class Arg {
    private final String shortOptionLetter;
    private final Object value;

    public Arg(String shortOptionLetter) {
        this(shortOptionLetter, null);
    }

    public Arg(String shortOptionLetter, Object valueOf) {
        this.shortOptionLetter = shortOptionLetter;
        this.value = valueOf;
    }

    public boolean matchesShortOptionLetter(String shortOptionLetter) {
        return this.shortOptionLetter.equals(shortOptionLetter);
    }

    public Object value() {
        return value;
    }
}
