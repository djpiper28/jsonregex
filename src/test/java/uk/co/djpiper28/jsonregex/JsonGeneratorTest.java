package uk.co.djpiper28.jsonregex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonGeneratorTest {
    @Test
    void testInvalidRootBoolean() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new JsonRegexGenerator(new JsonBoolean());
        });
    }

    @Test
    void testInvalidRootNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new JsonRegexGenerator(new JsonNumber());
        });
    }

    @Test
    void testInvalidRootString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new JsonRegexGenerator(new JsonString(JsonString.DEFAULT_PATTERN));
        });
    }

    @Test
    void testEscapeString() {
        Assertions.assertEquals(JsonRegexGenerator.escapeString("\\ \""), "\\\\ \\\"");
    }

    @Test
    void testObjectRoot() {
        JsonRegexGenerator generator = new JsonRegexGenerator(new JsonObject().addNode(new JsonNode("test", new JsonNumber())));
        Assertions.assertTrue("  {  \"test\"  :  123  }  ".matches(generator.getRegex()));
    }

    @Test
    void testArrayRoot() {
        JsonRegexGenerator generator = new JsonRegexGenerator(new JsonArray(new JsonNumber()));
        Assertions.assertTrue("  [123, 132]  ".matches(generator.getRegex()));
    }
}
