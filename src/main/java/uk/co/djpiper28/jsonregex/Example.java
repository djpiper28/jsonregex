package uk.co.djpiper28.jsonregex;

public class Example {
    public static void main(String[] args) {
        final String regex = new JsonRegexGenerator(
                new JsonArray(
                        new JsonObject()
                                .addNode(new JsonNode("id", new JsonString(JsonString.GUID_PATTERN)))
                                .addNode(new JsonNode("hours", new JsonNumber()))
                                .addNode(new JsonNode("minutes", new JsonNumber()))
                )
        ).getRegex();
        assert ("{\"id\":\"556fbaac-cc83-4772-bc8a-68fd507d0268\"}".matches(regex));
        assert ("{\"id\":\"556fbaac-cc83-4772-bc8a-68fd507d0268\",\"hours\":123}".matches(regex));
        assert ("{\"id\":\"556fbaac-cc83-4772-bc8a-68fd507d0268\",\"hours\":123,\"minutes\":123}".matches(regex));
        System.out.println(JsonRegexGenerator.escapeString(regex));
    }
}
