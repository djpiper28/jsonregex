package uk.co.djpiper28.jsonregex;

public class JsonString implements JsonPrimitive {

    public static final String DEFAULT_PATTERN = "([^\"]|(\\\\\"))*";
    private final String pattern;

    /**
     * Inits a Json String
     *
     * @param pattern a regex to match the contents of the string to. You need to escape speech marks otherwise things break.
     */
    public JsonString(final String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getRegex() {
        // " to \\" to escape the ", escape these again for \\ \\ \"
        return "\"" + this.pattern + "\"";
    }
}
