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

    @Test
    void parseDefaultStringArg_hasDefaultValue() {
        String schema = "n(String)";
        String args[] = {"-n"};
        Args result = new ArgsBuilder(schema).parse(args).build();
        assertEquals(1, result.size());
        Arg parsedArg = result.findArg("n");
        assertNotNull(parsedArg);
        assertEquals(parsedArg.value(), "");
    }

    @Test
    void parseStringArg_hasCorrespondingValue() {
        String schema = "n(String)";
        String args[] = {"-nPolly"};
        Args result = new ArgsBuilder(schema).parse(args).build();
        assertEquals(1, result.size());
        Arg parsedArg = result.findArg("n");
        assertNotNull(parsedArg);
        assertEquals(parsedArg.value(), "Polly");
    }
}
