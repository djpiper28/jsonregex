package uk.co.djpiper28.jsonregex;

import java.util.ArrayList;
import java.util.List;

public class JsonObject implements JsonPrimitive {
    List<JsonNode> nodes = new ArrayList<>();
    List<JsonNode> optionalNodes = new ArrayList<>();

    public JsonObject addNode(final JsonNode node) {
        this.nodes.add(node);
        return this;
    }

    public JsonObject addOptionalNode(final JsonNode node) {
        this.optionalNodes.add(node);
        return this;
    }

    private String getNodeRegexes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.size(); i++) {
            final JsonNode node = nodes.get(i);
            sb.append("\\s*" + node.getRegex() + "\\s*");
            if (i != nodes.size() - 1) {
                sb.append(",");
            }
        }

        for (int i = 0; i < optionalNodes.size(); i++) {
            final JsonNode node = optionalNodes.get(i);
            sb.append("(");
            if (nodes.size() > 0 || i > 0) {
                sb.append(",");
            }
            sb.append("\\s*" + node.getRegex() + "\\s*)?");
        }

        return sb.toString();
    }

    @Override
    public String getRegex() {
        return "\\{\\s*" + this.getNodeRegexes() + "\\s*\\}";
    }
}
