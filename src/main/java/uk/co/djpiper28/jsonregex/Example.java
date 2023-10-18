package uk.co.djpiper28.jsonregex;

public class Example {
    public static void main(String[] args) {
        final String regex = new JsonRegexGenerator(
                new JsonObject()
                        .addNode(new JsonNode("code", new JsonString("\\d{6}"), true))
                        .addNode(new JsonNode("test", new JsonString("\\d{6}"), true))
        ).getRegex();

        System.out.println(JsonRegexGenerator.escapeString(regex));
        System.out.println(regex);
    }
}
