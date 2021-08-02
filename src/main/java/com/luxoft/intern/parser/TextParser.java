package main.java.com.luxoft.intern.parser;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * This class must have functionality of parsing text and count
 * how many times each word found in that text
 */
public class TextParser {
    private final Logger log = Logger.getLogger(TextParser.class.getName());

    public Map<String, Integer> wordCounter(String fileName) {
        Map<String, Integer> map = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                Arrays.stream(scanner.next().toLowerCase().split(" +\\n?")).forEach(
                        w -> {
                            if (map.containsKey(w)) {
                                map.put(w, map.get(w) + 1);
                            } else {
                                map.put(w, 1);
                            }
                        }
                );
            }
        } catch (FileNotFoundException e) {
            log.severe("File not found!!!" + e.getMessage());
        }
        return map;
    }
}
