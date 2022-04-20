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
    void parameterWithInteger_hasMatchingValueTypeLiteral() {
        var parameter = Parameter.fromSchemaPart("n(Integer)");
        assertEquals("n", parameter.shortOptionLetter());
        assertTrue(parameter.hasValue());
        assertEquals("Integer", parameter.getValueTypeLiteral());
    }

    @Test
    void parameterWithString_hasMatchingValueTypeLiteral() {
        var parameter = Parameter.fromSchemaPart("t(String)");
        assertEquals("t", parameter.shortOptionLetter());
        assertTrue(parameter.hasValue());
        assertEquals("String", parameter.getValueTypeLiteral());
    }
}
