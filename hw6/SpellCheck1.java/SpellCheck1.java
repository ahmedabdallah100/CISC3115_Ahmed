import java.io.*;
import java.util.Scanner;
class Dictionary {
    private String dictionaryFileName;
    public Dictionary(String fileName) {
        dictionaryFileName = fileName;
    }
    public boolean found(String word) {
        try (Scanner scanner = new Scanner(new File(dictionaryFileName))) {
            while (scanner.hasNext()) {
                String dictWord = scanner.next().toLowerCase();
                if (dictWord.equals(word.toLowerCase())) {
                    return true;
                }
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found: " + e.getMessage());
        }
        return false;
    }
}
public class SpellCheck1 {
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
