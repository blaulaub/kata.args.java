package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValuedArgumentTest {

    @Test
    void parseDefaultIntegerArg_hasDefaultValue() {
        String schema = "i(Integer)";
        String args[] = {"-i"};
        Args result = new ArgsBuilder(schema).parse(args).build();
        assertEquals(1, result.size());
        Arg parsedArg = result.findArg("i");
        assertNotNull(parsedArg);
        assertEquals(parsedArg.value(), 0);
    }

    @Test
    void parseIntegerArg_hasCorrespondingValue() {
        String schema = "i(Integer)";
        String args[] = {"-i25"};
        Args result = new ArgsBuilder(schema).parse(args).build();
        assertEquals(1, result.size());
        Arg parsedArg = result.findArg("i");
        assertNotNull(parsedArg);
        assertEquals(parsedArg.value(), 25);
    }
}
