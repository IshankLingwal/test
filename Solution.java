
// ✅ Conclusion:
// If you're throwing a checked exception (like Exception or your custom exception that extends Exception), you must:

// Declare it with throws, OR

// Catch it with try-catch





import java.util.Scanner;

class MyCalculator {

    public int power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        } else if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        } else {
            return (int) Math.pow(n, p);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyCalculator calc = new MyCalculator();

        System.out.print("Enter number of test cases: ");
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.print("Enter n and p: ");
            int n = sc.nextInt();
            int p = sc.nextInt();

            try {
                int result = calc.power(n, p);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("java.lang.Exception: " + e.getMessage());
            }
        }

        sc.close();
    }
}

