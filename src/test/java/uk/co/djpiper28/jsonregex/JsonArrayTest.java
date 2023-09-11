package uk.co.djpiper28.jsonregex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonArrayTest {
    @Test
    void testJsonArrayNumber() {
        JsonArray jsonArray = new JsonArray(new JsonNumber());
        Assertions.assertTrue("[123,-123,123.123,-123.123]".matches(jsonArray.getRegex()));
    }

    @Test
    void testJsonArrayNumberOneItem() {
        JsonArray jsonArray = new JsonArray(new JsonNumber());
        Assertions.assertTrue("[123]".matches(jsonArray.getRegex()));
    }

    @Test
    void testJsonArrayNumberOneItemWhitespace() {
        JsonArray jsonArray = new JsonArray(new JsonNumber());
        Assertions.assertTrue("[  123  ]".matches(jsonArray.getRegex()));
    }

    @Test
    void testJsonArrayNumberWithWhiteSpace() {
        JsonArray jsonArray = new JsonArray(new JsonNumber());
        Assertions.assertTrue("[     123   ,      -123     ,   123.123 ,   -123.123         ]".matches(jsonArray.getRegex()));
    }

    @Test
    void testEmptyArray() {
        JsonArray jsonArray = new JsonArray(new JsonNumber());
        Assertions.assertTrue("[]".matches(jsonArray.getRegex()));
    }

    @Test
    void testEmptyArrayWhitespace() {
        JsonArray jsonArray = new JsonArray(new JsonNumber());
        Assertions.assertTrue("[         ]".matches(jsonArray.getRegex()));
    }
}
