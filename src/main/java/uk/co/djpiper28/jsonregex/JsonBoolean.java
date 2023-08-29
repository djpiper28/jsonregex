package uk.co.djpiper28.jsonregex;

public class JsonBoolean implements JsonPrimitive {

    @Override
    public String getRegex() {
        return "(true)|(false)";
    }
}
