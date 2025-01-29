import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    static int targetNumber;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        targetNumber = random.nextInt(100) + 1;
        
        System.out.println("I have thought of a number between 1 and 100.");
        boolean guessedCorrectly = false;
        
        while (!guessedCorrectly) {
            int guess = generateGuess();
            System.out.println("My guess: " + guess);
            System.out.print("Is my guess too high, too low, or correct? ");
            String feedback = scanner.nextLine().toLowerCase();
            
            guessedCorrectly = receiveFeedback(feedback, guess);
        }
        
        System.out.println("Yay! I guessed your number.");
    }

    public static int generateGuess() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    public static boolean receiveFeedback(String feedback, int guess) {
        if (feedback.equals("correct")) {
            return true;
        } else if (feedback.equals("high")) {
            targetNumber = guess - 1;
        } else if (feedback.equals("low")) {
            targetNumber = guess + 1;
        }
        return false;
    }
}

