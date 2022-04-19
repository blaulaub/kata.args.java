package ch.patchcode.kata.args.it1;

import java.util.ArrayList;
import java.util.List;

public class Args {

    private final List<Arg> args;

    public Args(List<Arg> args) {
        this.args = new ArrayList<>(args);
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
