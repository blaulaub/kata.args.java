package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

public class SimpleUsageTest {

    @Test
    void useWithoutAssertingResults() {
        String schema = "h";
        String args[] = {"-h"};
        Args result = Args.parse(schema, args);
    }
}
