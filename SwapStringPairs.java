import java.util.ArrayList;
import java.util.Scanner;

public class SwapStringPairs { 

    // Method to swap elements in pairs
    public static void swapPairs(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            // Swap element at i with element at i+1
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();

        System.out.print("Enter the number of words: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter word #" + (i + 1) + ": ");
            String word = sc.nextLine();
            words.add(word);
        }

        System.out.println("\nOriginal list: " + words);

        swapPairs(words);

        System.out.println("List after swapping pairs: " + words);

        sc.close();
    }
}
