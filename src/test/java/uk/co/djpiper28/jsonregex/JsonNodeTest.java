package uk.co.djpiper28.jsonregex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonNodeTest {
    @Test
    void testJsonStringNode() {
        JsonNode jsonNode = new JsonNode("test", new JsonString(JsonString.DEFAULT_PATTERN));
        Assertions.assertTrue("\"test\":\"lorem ipsum\"".matches(jsonNode.getRegex()));
    }

    @Test
    void testJsonStringNodeWhitespace() {
        JsonNode jsonNode = new JsonNode("test", new JsonString(JsonString.DEFAULT_PATTERN));
        Assertions.assertTrue("\"test\"  :  \"lorem ipsum\"".matches(jsonNode.getRegex()));
    }
}
