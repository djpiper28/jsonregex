package uk.co.djpiper28.jsonregex;

/**
 * A json array of @{@link JsonPrimitive}s, i.e: a string array.
 */
public class JsonArray implements JsonPrimitive {
    private final JsonPrimitive childrenFormat;

    public JsonArray(final JsonPrimitive childrenFormat) {
        this.childrenFormat = childrenFormat;
    }

    @Override
    public String getRegex() {
        return "\\[\\s*(" + childrenFormat.getRegex() + "(\\s*,\\s*" + childrenFormat.getRegex() + "\\s*)*" + ")?\\s*\\]";
    }
}
