package main.java.com.luxoft.intern.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * This class must have functionality of parsing text and count
 * how many times each word found in that text
 */
public class TextParser {
    private final Logger log = Logger.getLogger(TextParser.class.getName());

    public Map<String, Integer> wordCounter(String fileName) {
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) break;
                Arrays.stream(line.toLowerCase().split(" +\\n?")).forEach(
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
            log.severe("FILE NOT FOUND!!!" + e.getMessage());
        } catch (IOException e) {
            log.severe(e.getMessage());
        }
        return map;
    }
}
