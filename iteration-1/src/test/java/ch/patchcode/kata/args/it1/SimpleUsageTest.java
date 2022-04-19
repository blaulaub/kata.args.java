package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class SimpleUsageTest {

    @Test
    void useWithoutAssertingResults() {
        String schema = "h";
        String args[] = {"-h"};
        Args result = ignoreExceptions(() -> Args.parse(schema, args));
    }

    private <TResult> TResult ignoreExceptions(Supplier<TResult> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return null;
        }
    }

}
