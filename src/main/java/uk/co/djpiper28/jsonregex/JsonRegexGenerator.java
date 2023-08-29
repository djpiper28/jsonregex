package uk.co.djpiper28.jsonregex;

public class JsonRegexGenerator {
    final JsonPrimitive root;

    public JsonRegexGenerator(final JsonPrimitive root) {
        if (!(root instanceof JsonObject || root instanceof JsonArray)) {
            throw new IllegalArgumentException("The root of any JSON must be an array or object");
        }

        this.root = root;
    }

    public String generateJson() {
        return this.root.getRegex();
    }
}