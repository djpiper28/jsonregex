package uk.co.djpiper28.jsonregex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonStringTest {
    @Test
    void testJsonStringBasic() {
        JsonString jsonString = new JsonString(JsonString.DEFAULT_PATTERN);
        Assertions.assertTrue("\"wee wee poo poo 123\"".matches(jsonString.getRegex()));
    }

    @Test
    void testJsonStringWithString() {
        JsonString jsonString = new JsonString(JsonString.DEFAULT_PATTERN);
        Assertions.assertTrue("\"wee wee \\\" poo poo 123\"".matches(jsonString.getRegex()));
    }

    @Test
    void noneDefaultJsonStringPattern() {
        JsonString jsonString = new JsonString("[0-9]+");
        Assertions.assertTrue("\"123123123123123123123123\"".matches(jsonString.getRegex()));
    }

    @Test
    void noneDefaultJsonStringPatternWIthFail() {
        JsonString jsonString = new JsonString("[0-9]+");
        Assertions.assertFalse("\"testing 123\"".matches(jsonString.getRegex()));
    }
}
