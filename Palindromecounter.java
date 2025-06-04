import java.io.*;
import java.util.*;

public class Palindromecounter {

    // Method to check if a word is a palindrome
    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();  // Case-insensitive
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return word.length() > 1; // Single-letter words like "a" are not counted
    }

    public static void main(String[] args) {
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("myfile.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split on whitespace
                for (String word : words) {
                    // Clean word from punctuation if any
                    word = word.replaceAll("[^a-zA-Z]", "");

                    if (isPalindrome(word)) {
                        count++;
                    }
                }
            }

            br.close();
            System.out.println("Number of palindromes: " + count);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
