package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParameterTest {

    @Test
    void parameterWithoutModifier_hasNoValue() {
        var x = Parameter.fromParameter("n");
        assertEquals("n", x.shortOptionLetter());
        assertFalse(x.hasValue());
    }

    @Test
    void parameterWithModifier_hasValue() {
        var x = Parameter.fromParameter("n(Integer)");
        assertEquals("n", x.shortOptionLetter());
        assertTrue(x.hasValue());
    }
}
