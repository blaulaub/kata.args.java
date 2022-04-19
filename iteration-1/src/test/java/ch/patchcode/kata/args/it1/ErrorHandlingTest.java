package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorHandlingTest {

    @Test
    void runWithoutSchemaOrArgs_returnEmpty() {
        String schema = "";
        String args[] = {};
        Args result = Args.parse(schema, args);
        assertEquals(0, result.size());
    }
}
