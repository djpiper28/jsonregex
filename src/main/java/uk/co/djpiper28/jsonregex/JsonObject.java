package uk.co.djpiper28.jsonregex;

import java.util.ArrayList;
import java.util.List;

public class JsonObject implements JsonPrimitive {
    List<JsonNode> nodes;

    public JsonObject() {
        this.nodes = new ArrayList<>();
    }

    public JsonObject addNode(final JsonNode node) {
        this.nodes.add(node);
        return this;
    }

    private String getNodeRegexes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.size(); i++) {
            final JsonNode node = nodes.get(i);
            sb.append("\\s*" + node.getRegex());
            if (i != nodes.size() - 1) {
                sb.append("\\s*,");
            } else {
                sb.append("\\s*");
            }
        }
        return sb.toString();
    }

    @Override
    public String getRegex() {
        return "\\{\\s*" + this.getNodeRegexes() + "\\s*\\}";
    }
}
