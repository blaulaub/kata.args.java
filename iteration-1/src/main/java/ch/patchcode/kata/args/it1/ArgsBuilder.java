package ch.patchcode.kata.args.it1;

import java.util.*;
import java.util.stream.Collectors;

public class ArgsBuilder {

    private final Map<String, Parameter> schemaParts;
    private final List<Arg> parsedArgs = new ArrayList<>();

    public ArgsBuilder(String schema) {
        this.schemaParts = Arrays
                .stream(schema.split("\\|"))
                .filter(it -> !it.isEmpty())
                .map(Parameter::fromParameter)
                .collect(Collectors.<Parameter, String, Parameter>toMap(Parameter::shortOptionLetter, it -> it));
    }

    public ArgsBuilder parse(String[] args) {
        for (String arg: args) {

            if (!arg.startsWith("-")) throw new UnexpectedArgumentException(arg);
            String shortOptionLetter = arg.substring(1);

            if (!schemaParts.containsKey(shortOptionLetter)) throw new UnexpectedArgumentException(arg);

            parsedArgs.add(new Arg(shortOptionLetter));
        }
        return this;
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
