package uk.co.djpiper28.jsonregex;

public class JsonString implements JsonPrimitive {

    /**
     * A none-empty string.
     */
    public static final String DEFAULT_PATTERN = "([^\"]|(\\\\\"))+";
    /**
     * A Microsoft (tm) UUID.
     */
    public static final String GUID_PATTERN = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}";
    public static final String UUID_PATTERN = GUID_PATTERN;
    public static final String EMAIL_PATTERN = "[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*";
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
