package ch.patchcode.kata.args.it1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Args {

    private final List<Arg> args;

    public static class UnexpectedArgumentException extends RuntimeException {
        public UnexpectedArgumentException(String arg) {
            super(arg);
        }
    }

    public Args(List<Arg> args) {
        this.args = new ArrayList<>(args);
    }

    public static Args parse(String schema, String[] args) {
        Objects.requireNonNull(schema);
        List<Arg> parsedArgs = new ArrayList<>();
        for (String arg: args) {
            String letter = schema;
            if (!arg.equals("-" + letter)) {
                throw new UnexpectedArgumentException(arg);
            }
            parsedArgs.add(new Arg(letter));
        }
        return new Args(parsedArgs);
    }

    public Arg findArg(String h) {
        for (var arg: args) {
            if (arg.matchesShortOptionLetter(h)) return arg;
        }
        return null;
    }

    public int size() {
        return args.size();
    }
}
