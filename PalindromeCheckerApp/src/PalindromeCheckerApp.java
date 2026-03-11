import java.util.Scanner;

public class PalindromeCheckerApp {

    // Method to normalize input (remove spaces, punctuation, make lowercase)
    public static String normalize(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Method using two-pointer technique
    public static boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Alternative method using reverse
    public static boolean isPalindromeUsingReverse(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   Advanced Palindrome Checker");
        System.out.println("=================================");

        while (true) {

            System.out.print("\nEnter a word or sentence (or type 'exit'): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program...");
                break;
            }

            String normalized = normalize(input);

            if (normalized.length() == 0) {
                System.out.println("Invalid input. Please enter letters or numbers.");
                continue;
            }

            boolean result1 = isPalindrome(normalized);
            boolean result2 = isPalindromeUsingReverse(normalized);

            System.out.println("Processed Text: " + normalized);

            if (result1 && result2) {
                System.out.println("Result: ✅ It IS a palindrome.");
            } else {
                System.out.println("Result: ❌ It is NOT a palindrome.");
            }
        }

        scanner.close();
        System.out.println("Program terminated.");
    }
}