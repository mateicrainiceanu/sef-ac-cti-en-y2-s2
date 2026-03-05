package processors;

import documents.Document;

import java.util.ArrayList;

public class SearchProcessor implements Processor {
    private String searchText;

    public SearchProcessor(String searchText) {
        this.searchText = searchText;
    }

    public long process(ArrayList<Document> docs) {
        long count = 0;

        for (Document doc : docs) {
            count += doc
                .analyze()
                .stream()
                .filter(l -> l.contains(searchText))
                .count();
        }

        return count;

    }
}
