package documents;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class XMLDocument extends Document {

    public XMLDocument(ArrayList<String> contents) {
        super(contents);
    }

    @Override
    public ArrayList<String> analyze() {
        return super.getContents().stream().filter(
                line -> !(line.startsWith("<") && line.endsWith(">"))
        ).collect(Collectors.toCollection(ArrayList::new));
    }
}
