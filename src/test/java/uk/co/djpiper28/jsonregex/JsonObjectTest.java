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
        Assertions.assertTrue("  {   }    ".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectOneItem() {
        JsonObject jsonObject = new JsonObject().addNode(new JsonNode("test", new JsonNumber()));
        Assertions.assertTrue("{\"test\":123}".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectOneItemWhitespace() {
        JsonObject jsonObject = new JsonObject().addNode(new JsonNode("test", new JsonNumber()));
        Assertions.assertTrue("   {  \"test\"  :  123   }   ".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectManyItems() {
        JsonObject jsonObject = new JsonObject()
                .addNode(new JsonNode("test", new JsonNumber()))
                .addNode(new JsonNode("test2", new JsonBoolean()));
        Assertions.assertTrue("{\"test\":123,\"test2\":false}".matches(jsonObject.getRegex()));
    }

    @Test
    void testJsonObjectManyItemsWhitespace() {
        JsonObject jsonObject = new JsonObject()
                .addNode(new JsonNode("test", new JsonNumber()))
                .addNode(new JsonNode("test2", new JsonBoolean()));
        Assertions.assertTrue("  {  \"test\"  :  123  ,  \"test2\"  :  false  }  ".matches(jsonObject.getRegex()));
    }
}
