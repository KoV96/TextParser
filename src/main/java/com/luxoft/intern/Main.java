package main.java.com.luxoft.intern;

import main.java.com.luxoft.intern.parser.TextParser;

public class Main {
    private static final String FILE_NAME = "text.txt";

    public static void main(String[] args) {
        TextParser textParser = new TextParser();
        textParser.wordCounter(FILE_NAME)
                .forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
