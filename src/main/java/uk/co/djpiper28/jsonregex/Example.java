package uk.co.djpiper28.jsonregex;

public class Example {
    public static void main(String[] args) {
        final String regex = new JsonRegexGenerator(
                new JsonObject()
                        .addNode(new JsonNode("emailAddress", new JsonString(JsonString.EMAIL_PATTERN)))
                        .addNode(new JsonNode("code", new JsonString("\\d{6}")))
        ).getRegex();

        System.out.println(JsonRegexGenerator.escapeString(regex));
        System.out.println(regex);
    }
}
