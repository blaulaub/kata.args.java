package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParameterTest {

    @Test
    void parameterWithModifier_hasValue() {
        var x = Parameter.fromParameter("n(Integer)");
        assertEquals("n", x.shortOptionLetter());
        assertTrue(x.hasValue());
    }
}
