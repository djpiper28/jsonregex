package uk.co.djpiper28.jsonregex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class JsonObject implements JsonPrimitive {
    List<JsonNode> nodes = new ArrayList<>();

    public JsonObject addNode(final JsonNode node) {
        this.nodes.add(node);
        return this;
    }

    private static String getNodeRegexes(List<JsonNode> nodes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.size(); i++) {
            final JsonNode node = nodes.get(i);

            sb.append('(');
            if (i > 0 && node.isOptional()) {
                sb.append(',');
            }

            sb.append("\\s*");
            sb.append(node.getRegex());
            sb.append("\\s*");;

            if (i + 1 < nodes.size() && !nodes.get(i + 1).isOptional()) {
                sb.append(',');
            }
            sb.append(')');

            if (node.isOptional()) {
                sb.append('?');
            }
        }

        return sb.toString();
    }
    private static <E> void iteratePermutations(List<E> original, Consumer<List<E>> consumer) {
        Objects.requireNonNull(original);
        consumer.accept(original);
        iteratePermutationsRecursively(original, 0, consumer);
    }

    private static <E> void iteratePermutationsRecursively(List<E> original, int start, Consumer<List<E>> consumer) {
        Objects.requireNonNull(original);
        for (int i = start; i < original.size() - 1; i++) {
            for (int j = i + 1; j < original.size(); j++) {
                List<E> temp = new ArrayList<>(original);
                E tempVal = temp.get(i);
                temp.set(i, temp.get(j));
                temp.set(j, tempVal);
                consumer.accept(temp);
                iteratePermutationsRecursively(temp, i + 1, consumer);
            }
        }
    }

    private String getAllPermuatationNodeRegexes() {
        final StringBuilder stringBuilder = new StringBuilder();
        iteratePermutations(this.nodes, (jsonNodes -> {
            stringBuilder.append('(');
            stringBuilder.append(getNodeRegexes(jsonNodes));
            stringBuilder.append(")|");
        }));

        final String ret = stringBuilder.toString();
        return ret.substring(0, ret.length() - 1); // Strip last or as it is not needed
    }

    @Override
    public String getRegex() {
        return "\\{\\s*(" + this.getAllPermuatationNodeRegexes() + ")\\s*\\}";
    }
}
