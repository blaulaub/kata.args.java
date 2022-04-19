package ch.patchcode.kata.args.it1;

public class Arg {
    private final String shortOptionLetter;

    public Arg(String shortOptionLetter) {
        this.shortOptionLetter = shortOptionLetter;
    }

    public boolean matchesShortOptionLetter(String shortOptionLetter) {
        return this.shortOptionLetter.equals(shortOptionLetter);
    }
}
