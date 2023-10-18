package uk.co.djpiper28.jsonregex;

import java.util.ArrayList;
import java.util.List;

public class JsonObject implements JsonPrimitive {
    List<JsonNode> nodes = new ArrayList<>();

    public JsonObject addNode(final JsonNode node) {
        this.nodes.add(node);
        return this;
    }

    private String getNodeRegexes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.size(); i++) {
            final JsonNode node = nodes.get(i);
            sb.append('(');
            sb.append("\\s*");
            sb.append(node.getRegex());
            sb.append("\\s*");;

            if (i != nodes.size() - 1) {
                sb.append(",");
            }
            sb.append(')');

            if (node.isOptional()) {
                sb.append('?');
            }
        }

        return sb.toString();
    }

    @Override
    public String getRegex() {
        return "\\{\\s*" + this.getNodeRegexes() + "\\s*\\}";
    }
}
