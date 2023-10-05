import java.io.*;
import java.util.Scanner;
class Dictionary {
    private String[] words;
    public Dictionary(String fileName) {
        int wordCount = countWordsInFile(fileName);
        words = new String[wordCount];
        initializeWordsArray(fileName);
    }
    private int countWordsInFile(String fileName) {
        int count = 0;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found: " + e.getMessage());
        }
        return count;
    }
    private void initializeWordsArray(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int index = 0;
            while (scanner.hasNext()) {
                words[index] = scanner.next().toLowerCase();
                index++;
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found: " + e.getMessage());
        }
    }
    public boolean found(String word) {
        word = word.toLowerCase();
        for (String dictWord : words) {
            if (dictWord.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
public class SpellCheck3 {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("Dictionary");
        int lineNumber = 1;
        try (Scanner scanner = new Scanner(new File("paper"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                while (lineScanner.hasNext()) {
                    String word = lineScanner.next();
                    if (!dictionary.found(word)) {
                        System.out.printf("Line %4d: %s%n", lineNumber, word);
                    }
                }
                lineNumber++;
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Paper file not found: " + e.getMessage());
        }
    }
}
