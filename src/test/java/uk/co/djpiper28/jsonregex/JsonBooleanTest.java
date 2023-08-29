package uk.co.djpiper28.jsonregex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonBooleanTest {
    @Test
    void testTrue() {
        Assertions.assertTrue("true".matches(new JsonBoolean().getRegex()));
    }

    @Test
    void testFalse() {
        Assertions.assertTrue("false".matches(new JsonBoolean().getRegex()));
    }

    @Test
    void testFail() {
        Assertions.assertFalse("trueish".matches(new JsonBoolean().getRegex()));
    }
}
