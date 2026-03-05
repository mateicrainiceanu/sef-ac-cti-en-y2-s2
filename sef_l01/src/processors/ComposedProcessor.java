package processors;

import documents.Document;

import java.util.ArrayList;

public class ComposedProcessor implements Processor {

    ArrayList<Processor> processors;

    public ComposedProcessor(ArrayList<Processor> processors) {
        this.processors = processors;
    }

    @Override
    public long process(ArrayList<Document> docs) {
        long count = 0;
        for (Processor processor : processors) {
            count += processor.process(docs);
        }

        return count;
    }
}
