package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleArgumentsTest {

    @Test
    void parseOneSimpleArgument() {
        String schema = "h";
        String args[] = {"-h"};
        Args result = ArgsFactory.parse(schema, args);
        assertEquals(1, result.size());
        assertNotNull(result.findArg("h"));
    }
}
