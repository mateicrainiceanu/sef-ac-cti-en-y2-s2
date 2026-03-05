package documents;

import java.util.ArrayList;

abstract public class Document {
    ArrayList<String> contents;
    public Document(ArrayList<String> contents) {
        this.contents = contents;
    }

    abstract public ArrayList<String> analyze();

    public ArrayList<String> getContents() {
        return contents;
    }

    public void setContents(ArrayList<String> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return contents.toString();
    }

    public void display() {
        System.out.println(toString());
    }
}
