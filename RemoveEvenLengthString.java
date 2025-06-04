import java.util.ArrayList;

public class RemoveEvenLengthStrings {

    public static void removeEvenLength(ArrayList<String> list) {
        // Loop from the end to avoid skipping elements when removing
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).length() % 2 == 0) {
                list.remove(i); // Remove strings with even length
            }
        }
    }

    public static void main(String[] args) {
        // Sample list
        ArrayList<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("kiwi");
        words.add("mango");
        words.add("peach");
        words.add("plum");

        System.out.println("Original List: " + words);

        // Call the method to remove even-length strings
        removeEvenLength(words);

        System.out.println("After Removing Even-Length Strings: " + words);
    }
}


//import java.util.ArrayList;
// import java.util.Scanner;

// public class RemoveEvenLengthStrings {

//     // Method to remove even-length strings from the list
//     public static void removeEvenLength(ArrayList<String> list) {
//         for (int i = list.size() - 1; i >= 0; i--) {
//             if (list.get(i).length() % 2 == 0) {
//                 list.remove(i);
//             }
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         ArrayList<String> words = new ArrayList<>();

//         System.out.print("Enter the number of words: ");
//         int n = sc.nextInt();
//         sc.nextLine();  // Consume the leftover newline

//         for (int i = 0; i < n; i++) {
//             System.out.print("Enter word #" + (i + 1) + ": ");
//             String word = sc.nextLine();
//             words.add(word);
//         }

//         System.out.println("\nOriginal List: " + words);

//         // Remove even-length strings
//         removeEvenLength(words);

//         System.out.println("List after removing even-length strings: " + words);
        
//         sc.close(); // Close the scanner
//     }
// }
