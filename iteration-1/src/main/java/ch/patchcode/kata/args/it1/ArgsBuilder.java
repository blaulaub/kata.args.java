package ch.patchcode.kata.args.it1;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class ArgsBuilder {

    private final Map<String, Parameter> schemaParts;
    private final List<Arg> parsedArgs = new ArrayList<>();

    public ArgsBuilder(String schema) {
        this.schemaParts = Arrays
                .stream(schema.split("\\|"))
                .filter(it -> !it.isEmpty())
                .map(Parameter::fromSchemaPart)
                .collect(Collectors.<Parameter, String, Parameter>toMap(Parameter::shortOptionLetter, it -> it));
    }

    public ArgsBuilder parse(String[] args) {
        var argList = new LinkedList<>(asList(args));
        while (!argList.isEmpty()) {
            var arg = argList.pollFirst();

            if (!arg.startsWith("-")) throw new UnexpectedArgumentException(arg);
            String shortOptionLetter = arg.substring(1,2);

            Parameter parameter = schemaParts.get(shortOptionLetter);
            if (parameter == null) throw new UnexpectedArgumentException(arg);

            if (parameter.getValueTypeLiteral() == null || parameter.getValueTypeLiteral().equals("")) {
                parsedArgs.add(new Arg(shortOptionLetter));
            } else if (parameter.getValueTypeLiteral().equals("Integer")) {
                String valueString = arg.substring(2);
                if (valueString.equals("")) {
                    parsedArgs.add(new Arg(shortOptionLetter, 0));
                } else {
                    parsedArgs.add(new Arg(shortOptionLetter, Integer.valueOf(valueString)));
                }
            } else {
                throw new RuntimeException("not implemented: " + parameter.getValueTypeLiteral());
            }

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
