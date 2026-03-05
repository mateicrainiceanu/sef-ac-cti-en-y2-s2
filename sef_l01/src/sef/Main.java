package sef;

import documents.Document;
import documents.JSONDocument;
import documents.XMLDocument;
import processors.ComposedProcessor;
import processors.SearchProcessor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        XMLDocument xml = new XMLDocument(new ArrayList<>(List.of(
                "<root>",
                "<child>", "Hello", "</child>",
                "</root>",
                "plain text line"
        )));

        JSONDocument json = new JSONDocument(new ArrayList<>(List.of(
                "{",
                "  \"name\": \"Alice\",",
                "  \"age\": \"30\",",
                "  \"Hello\": \"Hello\"",
                "}"
        )));

        System.out.println("Display");
        xml.display();
        System.out.println("Display");
        json.display();
        System.out.println("\n-----");

        System.out.println("Analyse XML");
        System.out.println(xml.analyze());
        System.out.println("Analyse JSON");
        System.out.println(json.analyze());

        System.out.println("Search document 1");
        SearchProcessor sp = new SearchProcessor("Hello");
        System.out.println(sp.process(new ArrayList<Document>(List.of(xml))));

        System.out.println("Search document 2");
        System.out.println(sp.process(new ArrayList<Document>(List.of(json))));

        System.out.println("Search both documents");
        System.out.println(sp.process(new ArrayList<Document>(List.of(xml, json))));

        System.out.println("Search both documents composed search");
        SearchProcessor sp2 = new SearchProcessor("Alice");
        ComposedProcessor cp = new ComposedProcessor(new ArrayList<>(List.of(sp, sp2)));
        System.out.println(cp.process(new ArrayList<>(List.of(xml, json))));
    }
}