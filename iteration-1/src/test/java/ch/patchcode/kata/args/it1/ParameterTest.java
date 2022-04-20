package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParameterTest {

    @Test
    void parameterWithoutModifier_hasNoValue() {
        var parameter = Parameter.fromSchemaPart("n");
        assertEquals("n", parameter.shortOptionLetter());
        assertFalse(parameter.hasValue());
    }

    @Test
    void parameterWithModifier_hasValue() {
        var parameter = Parameter.fromSchemaPart("n(Integer)");
        assertEquals("n", parameter.shortOptionLetter());
        assertTrue(parameter.hasValue());
    }
}
