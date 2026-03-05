package processors;

import documents.Document;

import java.util.ArrayList;

public interface Processor {
    long process(ArrayList<Document> docs);
}