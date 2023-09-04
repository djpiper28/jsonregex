package uk.co.djpiper28.jsonregex;

public class Example {
    public static void main(String[] args) {
        final String regex = new JsonRegexGenerator(
                new JsonObject()
                        .addNode(new JsonNode("makeId", new JsonString(JsonString.GUID_PATTERN)))
                        .addNode(new JsonNode("modelId", new JsonString(JsonString.GUID_PATTERN)))
                        .addOptionalNode(new JsonNode("hours", new JsonNumber()))
                        .addOptionalNode(new JsonNode("minutes", new JsonNumber()))
        ).getRegex();
        assert ("{\"makeId\":\"556fbaac-cc83-4772-bc8a-68fd507d0268\",\"modelId\":\"c87c66a5-2913-4e67-b6ab-cc9ea42fd079\"}".matches(regex));
        assert ("{\"makeId\":\"556fbaac-cc83-4772-bc8a-68fd507d0268\",\"modelId\":\"c87c66a5-2913-4e67-b6ab-cc9ea42fd079\",\"hours\":123}".matches(regex));
        assert ("{\"makeId\":\"556fbaac-cc83-4772-bc8a-68fd507d0268\",\"modelId\":\"c87c66a5-2913-4e67-b6ab-cc9ea42fd079\",\"hours\":123,\"minutes\":123}".matches(regex));
        System.out.println(JsonRegexGenerator.escapeString(regex));
    }
}
