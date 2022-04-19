package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class SimpleUsageTest {

    @Test
    void useWithoutAssertingResults() {
        String schema = "h";
        String args[] = {"-h"};
        Args result = ignoreExceptions(() -> new ArgsBuilder(schema).parse(args).build());
    }

    private <TResult> TResult ignoreExceptions(Supplier<TResult> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return null;
        }
    }

}
