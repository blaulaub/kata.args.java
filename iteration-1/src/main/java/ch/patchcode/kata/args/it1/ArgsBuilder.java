package ch.patchcode.kata.args.it1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArgsBuilder {

    private final List<Arg> parsedArgs = new ArrayList<>();

    public ArgsBuilder parse(String schema, String[] args) {
        Objects.requireNonNull(schema);
        var schemaParts = schema.split("\\|");
        for (String arg: args) {
            String letter = schemaParts[0];
            tryMatchArgWithLetter(arg, letter);
        }
        return this;
    }

    private void tryMatchArgWithLetter(String arg, String letter) {
        if (!arg.equals("-" + letter)) {
            throw new UnexpectedArgumentException(arg);
        }
        parsedArgs.add(new Arg(letter));
    }

    public Args build() {
        return new Args(parsedArgs);
    }

    public static class UnexpectedArgumentException extends RuntimeException {
        public UnexpectedArgumentException(String arg) {
            super(arg);
        }
    }
}
