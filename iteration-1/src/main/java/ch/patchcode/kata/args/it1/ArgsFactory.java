package ch.patchcode.kata.args.it1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArgsFactory {
    public static Args parse(String schema, String[] args) {
        Objects.requireNonNull(schema);
        var schemaParts = schema.split("\\|");
        List<Arg> parsedArgs = new ArrayList<>();
        for (String arg: args) {
            String letter = schemaParts[0];
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
