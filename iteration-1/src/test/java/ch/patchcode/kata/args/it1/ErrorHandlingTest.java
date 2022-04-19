package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorHandlingTest {

    @Test
    void runWithoutSchemaOrArgs_returnEmpty() {
        String schema = "";
        String args[] = {};
        Args result = Args.parse(schema, args);
        assertEquals(0, result.size());
    }

    @Test
    void unexpectedArg_throwsException() {
        String schema = "";
        String args[] = {"-h"};
        assertThrows(Args.UnexpectedArgumentException.class, () -> Args.parse(schema, args));
    }

    @Test
    void argWithoutLeadingDash_throwsException() {
        String schema = "";
        String args[] = {"nodash"};
        assertThrows(Args.UnexpectedArgumentException.class, () -> Args.parse(schema, args));
    }
}
