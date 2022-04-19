package ch.patchcode.kata.args.it1;

import java.util.Objects;

public class Args {

    private final int count;

    public static class UnexpectedArgumentException extends RuntimeException {
        public UnexpectedArgumentException(String arg) {
            super(arg);
        }
    }

    public Args(int count) {
        this.count = count;
    }

    public static Args parse(String schema, String[] args) {
        Objects.requireNonNull(schema);
        int count = 0;
        for (String arg: args) {
            if (!arg.equals("-" + schema)) {
                throw new UnexpectedArgumentException(arg);
            }
            count++;
        }
        return new Args(count);
    }

    public int size() {
        return count;
    }
}
