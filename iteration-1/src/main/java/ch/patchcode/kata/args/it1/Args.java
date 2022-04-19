package ch.patchcode.kata.args.it1;

public class Args {

    public static class UnexpectedArgumentException extends RuntimeException {
        public UnexpectedArgumentException(String arg) {
            super(arg);
        }
    }

    public static Args parse(String schema, String[] args) {
        for (String arg: args) {
            throw new UnexpectedArgumentException(arg);
        }
        return new Args();
    }

    public int size() {
        return 0;
    }
}
