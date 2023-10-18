package uk.co.djpiper28.jsonregex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Example {
    public static void main(String[] args) throws FileNotFoundException {
        final String regex = new JsonRegexGenerator(
                new JsonObject()
                        .addNode(new JsonNode("line1", new JsonString(JsonString.DEFAULT_PATTERN)))
                        .addNode(new JsonNode("line2", new JsonString(JsonString.DEFAULT_PATTERN), true))
                        .addNode(new JsonNode("line3", new JsonString(JsonString.DEFAULT_PATTERN), true))
                        .addNode(new JsonNode("county", new JsonString(JsonString.DEFAULT_PATTERN), true))
                        .addNode(new JsonNode("country", new JsonString(JsonString.DEFAULT_PATTERN)))
                        .addNode(new JsonNode("townCity", new JsonString(JsonString.DEFAULT_PATTERN)))
                        .addNode(new JsonNode("postcode", new JsonString(JsonString.DEFAULT_PATTERN)))
        ).getRegex();

        final PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.println(JsonRegexGenerator.escapeString(regex));
        pw.close();
    }
}
