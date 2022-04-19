package ch.patchcode.kata.args.it1;

import org.junit.jupiter.api.Test;

public class FirstTest {

    @Test
    void test() {
        String schema = "h";
        String args[] = {"-h"};
        Args.parse(schema, args);
    }
}
