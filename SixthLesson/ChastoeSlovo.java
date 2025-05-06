package SixthLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String text = reader.lines()
                .reduce("", (s1, s2) -> s1 + " " + s2).trim();

        String[] words = text.split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        String mostFrequentWord = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && (mostFrequentWord == null || word.compareTo(mostFrequentWord) < 0))) {
                mostFrequentWord = word;
                maxCount = count;
            }
        }

        writer.write(mostFrequentWord);
        writer.newLine();

        reader.close();
        writer.close();
    }
}