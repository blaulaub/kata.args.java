package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorHandlingTest {

    @Test
    void runWithoutSchemaOrArgs_returnEmpty() {
        String schema = "";
        String args[] = {};
        Args result = ArgsFactory.parse(schema, args);
        assertEquals(0, result.size());
        assertNull(result.findArg("h"));
    }

    @Test
    void unexpectedArg_throwsException() {
        String schema = "";
        String args[] = {"-h"};
        assertThrows(ArgsFactory.UnexpectedArgumentException.class, () -> ArgsFactory.parse(schema, args));
    }

    @Test
    void argWithoutLeadingDash_throwsException() {
        String schema = "";
        String args[] = {"nodash"};
        assertThrows(ArgsFactory.UnexpectedArgumentException.class, () -> ArgsFactory.parse(schema, args));
    }

    @Test
    void nullSchema_throwsException() {
        String schema = null;
        String args[] = {""};
        assertThrows(NullPointerException.class, () -> ArgsFactory.parse(schema, args));
    }

    @Test
    void nullArgs_throwsException() {
        String schema = "";
        String args[] = null;
        assertThrows(NullPointerException.class, () -> ArgsFactory.parse(schema, args));
    }
}
