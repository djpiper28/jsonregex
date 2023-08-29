package uk.co.djpiper28.jsonregex;

/**
 * A node of an object, i.e: "test": "value"
 */
public class JsonNode {
    private final String key;
    private final JsonPrimitive value;

    public JsonNode(final String key, final JsonPrimitive value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Does not implement this via JsonPrimitive as this is not a primitive.
     *
     * @return regex to match this node, the comma (,) is not done by this class and handled by the JsonObject
     */
    public String getRegex() {
        return "\"" + this.key + "\"\\s*:\\s*(" + this.value.getRegex() + ")";
    }
}
