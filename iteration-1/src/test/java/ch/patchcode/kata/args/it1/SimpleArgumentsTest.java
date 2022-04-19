package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleArgumentsTest {

    @Test
    void parseOneSimpleArgument() {
        String schema = "h";
        String args[] = {"-h"};
        Args result = new ArgsBuilder(schema).parse(args).build();
        assertEquals(1, result.size());
        assertNotNull(result.findArg("h"));
    }

    @Test
    void parseFirstOfTwoSimpleArguments() {
        String schema = "h|v";
        String args[] = {"-h"};
        Args result = new ArgsBuilder(schema).parse(args).build();
        assertEquals(1, result.size());
        assertNotNull(result.findArg("h"));
        assertNull(result.findArg("v"));
    }

    @Test
    void parseTwoSimpleArguments() {
        String schema = "h|v";
        String args[] = {"-h", "-v"};
        Args result = new ArgsBuilder(schema).parse(args).build();
        assertEquals(2, result.size());
        assertNotNull(result.findArg("h"));
        assertNotNull(result.findArg("v"));
    }

    @Test
    void parseSecondOfTwoSimpleArguments() {
        String schema = "h|v";
        String args[] = {"-v"};
        Args result = new ArgsBuilder(schema).parse(args).build();
        assertEquals(1, result.size());
        assertNull(result.findArg("h"));
        assertNotNull(result.findArg("v"));
    }
}
