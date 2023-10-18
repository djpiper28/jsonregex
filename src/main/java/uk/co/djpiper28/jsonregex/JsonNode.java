package uk.co.djpiper28.jsonregex;

/**
 * A node of an object, i.e: "test": "value"
 */
public class JsonNode {
    private final String key;
    private final JsonPrimitive value;
    private final boolean optional;

    /**
     * A mendatory field in the JSON object.
     *
     * @param key
     * @param value
     */
    public JsonNode(final String key, final JsonPrimitive value) {
        this.key = key;
        this.value = value;
        this.optional = false;
    }

    public JsonNode(final String key, final JsonPrimitive value, final boolean optional) {
        this.key = key;
        this.value = value;
        this.optional = optional;
    }

    /**
     * Does not implement this via JsonPrimitive as this is not a primitive.
     *
     * @return regex to match this node, the comma (,) is not done by this class and handled by the JsonObject
     */
    public String getRegex() {
        return "\"" + this.key + "\"\\s*:\\s*(" + this.value.getRegex() + ")";
    }


    /**
     * Used by the JSON Object as that needs to know if it can put a comma afterwards.
     * @return
     */
    public boolean isOptional() {
        return optional;
    }
}
