package ch.patchcode.kata.args.it1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArgsFactory {
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

    public static class UnexpectedArgumentException extends RuntimeException {
        public UnexpectedArgumentException(String arg) {
            super(arg);
        }
    }
}
