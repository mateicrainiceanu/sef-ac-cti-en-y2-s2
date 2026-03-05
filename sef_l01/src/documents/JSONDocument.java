package documents;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class JSONDocument extends Document{

    public JSONDocument(ArrayList<String> contents) {
        super(contents);
    }

    @Override
    public ArrayList<String> analyze() {
        return
                getKeyValuePairs().stream()
                .map(s -> s.contains(":") ? s.split(":")[1].replaceAll("\"", "") : s)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public String toString() {
        return "JSON " + getKeyValuePairs().toString();
    }

    private ArrayList<String> getKeyValuePairs() {
        return super.getContents().stream()
                .map(l -> l
                        .replace("{", "")
                        .replace("}", "")
                        .replace(",", "")
                        .replace("\"", "")
                        .trim()
                )
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));

    }
}
