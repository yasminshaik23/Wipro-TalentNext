import java.io.*;
import java.util.*;

public class FileWordCount {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java FileWordCount <inputFile> <outputFile>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        TreeMap<String, Integer> wordCount = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading input file.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                bw.write(entry.getKey() + " : " + entry.getValue());
                bw.newLine();
            }

            System.out.println("Word count written to " + outputFile);

        } catch (IOException e) {
            System.out.println("Error writing output file.");
        }
    }
}