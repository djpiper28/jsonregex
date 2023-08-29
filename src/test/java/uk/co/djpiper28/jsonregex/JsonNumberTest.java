package uk.co.djpiper28.jsonregex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonNumberTest {
    @Test
    void testNumberBase() {
        Assertions.assertTrue("123123".matches(new JsonNumber().getRegex()));
    }

    @Test
    void testNumberDecimal() {
        Assertions.assertTrue("123123.123123".matches(new JsonNumber().getRegex()));
    }

    @Test
    void testNumberNegative() {
        Assertions.assertTrue("-123123".matches(new JsonNumber().getRegex()));
    }

    @Test
    void testNumberFail() {
        Assertions.assertFalse("1231aaads23123".matches(new JsonNumber().getRegex()));
    }

    @Test
    void testNumberNegativeDecimal() {
        Assertions.assertTrue("-123.123".matches(new JsonNumber().getRegex()));
    }
}
