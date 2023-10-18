package uk.co.djpiper28.jsonregex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonObjectTest {
    @Test
    void testJsonObjectEmpty() {
        JsonObject jsonObject = new JsonObject();
        Assertions.assertTrue("{}".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectEmptyWhitespace() {
        JsonObject jsonObject = new JsonObject();
        Assertions.assertTrue("{   }".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectOneItem() {
        JsonObject jsonObject = new JsonObject().addNode(new JsonNode("test", new JsonNumber()));
        Assertions.assertTrue("{\"test\":123}".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectOneItemWhitespace() {
        JsonObject jsonObject = new JsonObject().addNode(new JsonNode("test", new JsonNumber()));
        Assertions.assertTrue("{  \"test\"  :  123   }".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectManyItems() {
        JsonObject jsonObject = new JsonObject()
                .addNode(new JsonNode("test", new JsonNumber()))
                .addNode(new JsonNode("test2", new JsonBoolean()));
        Assertions.assertTrue("{\"test\":123,\"test2\":false}".matches(jsonObject.getRegex()));
        Assertions.assertTrue("{\"test2\":false,\"test\":132}".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectManyItemsWhitespace() {
        JsonObject jsonObject = new JsonObject()
                .addNode(new JsonNode("test", new JsonNumber()))
                .addNode(new JsonNode("test2", new JsonBoolean()));
        Assertions.assertTrue("{  \"test\"  :  123  ,  \"test2\"  :  false  }".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectSingleOptional() {
        JsonObject jsonObject = new JsonObject()
                .addNode(new JsonNode("test", new JsonNumber(), true));
        Assertions.assertTrue("{\"test\":123}".matches(jsonObject.getRegex()));
        Assertions.assertTrue("{}".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectSingleOptionalWhitespace() {
        JsonObject jsonObject = new JsonObject()
                .addNode(new JsonNode("test", new JsonNumber(), true));
        Assertions.assertTrue("{   \"test\"  :  123   }".matches(jsonObject.getRegex()));
        Assertions.assertTrue("{   }".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectOptionalAfterRequired() {
        JsonObject jsonObject = new JsonObject()
                .addNode(new JsonNode("thing", new JsonNumber()))
                .addNode(new JsonNode("test", new JsonNumber(), true));
        Assertions.assertTrue("{\"thing\":123,\"test\":123}".matches(jsonObject.getRegex()));
        Assertions.assertTrue("{\"test\":123,\"thing\":123}".matches(jsonObject.getRegex()));
        Assertions.assertTrue("{\"thing\":123}".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectOptionalAfterRequiredWhitespace() {
        JsonObject jsonObject = new JsonObject()
                .addNode(new JsonNode("thing", new JsonNumber(), false))
                .addNode(new JsonNode("test", new JsonNumber(), true));
        Assertions.assertTrue("{  \"thing\"  :  123  ,  \"test\"  :  123  }".matches(jsonObject.getRegex()));
        Assertions.assertTrue("{  \"thing\"  :  123  }".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectOptionalsAfterRequired() {
        JsonObject jsonObject = new JsonObject()
                .addNode(new JsonNode("thing", new JsonNumber()))
                .addNode(new JsonNode("test", new JsonNumber()))
                .addNode(new JsonNode("test2", new JsonNumber(), true));
        Assertions.assertTrue("{\"thing\":123,\"test\":123,\"test2\":321}".matches(jsonObject.getRegex()));
        Assertions.assertTrue("{\"test\":123,\"thing\":123}".matches(jsonObject.getRegex()));
        Assertions.assertTrue("{\"thing\":123,\"test\":123}".matches(jsonObject.getRegex()));
    }

    @Test
    void testSingleOptionalNode() {
        final String regex = new JsonRegexGenerator(
                new JsonObject()
                        .addNode(new JsonNode("code", new JsonString("\\d{6}"), true))
        ).getRegex();

        Assertions.assertTrue("{}".matches(regex));
        Assertions.assertTrue("{\"code\":\"123456\"}".matches(regex));
    }
}
