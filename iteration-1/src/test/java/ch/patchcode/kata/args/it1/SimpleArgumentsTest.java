package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleArgumentsTest {

    @Test
    void parseOneSimpleArgument() {
        String schema = "h";
        String args[] = {"-h"};
        Args result = new ArgsBuilder().parse(schema, args).build();
        assertEquals(1, result.size());
        assertNotNull(result.findArg("h"));
    }

    @Test
    void parseFirstOfTwoSimpleArguments() {
        String schema = "h|v";
        String args[] = {"-h"};
        Args result = new ArgsBuilder().parse(schema, args).build();
        assertEquals(1, result.size());
        assertNotNull(result.findArg("h"));
        assertNull(result.findArg("v"));
    }
}
