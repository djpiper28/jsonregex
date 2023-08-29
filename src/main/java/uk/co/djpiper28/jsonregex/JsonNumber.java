package uk.co.djpiper28.jsonregex;

public class JsonNumber implements JsonPrimitive {
    @Override
    public String getRegex() {
        return "-?[0-9]+(\\.[0-9]+)?";
    }
}
