package uk.co.djpiper28.jsonregex;

public class JsonRegexGenerator {
    final JsonPrimitive root;

    public JsonRegexGenerator(final JsonPrimitive root) {
        if (!(root instanceof JsonObject || root instanceof JsonArray)) {
            throw new IllegalArgumentException("The root of any JSON must be an array or object");
        }

        this.root = root;
    }

    public String getRegex() {
        return "\\s*" + this.root.getRegex() + "\\s*";
    }

    /**
     * Esacpes a regex string, really useful if the regex string is being stored in JSON for example.
     *
     * @param regex regex string
     * @return escaoed regex string
     */
    public static String escapeString(final String regex) {
        return regex.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
