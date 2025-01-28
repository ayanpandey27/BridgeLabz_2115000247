import java.util.Random;

public class StudentScorecard {

    // Method to generate random scores for Physics, Chemistry, and Math
    public static int[][] generateScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3]; // [0] = Physics, [1] = Chemistry, [2] = Math

        for (int i = 0; i < numStudents; i++) {
            // Generating random scores between 50 and 99 for each subject
            scores[i][0] = 50 + rand.nextInt(50); // Physics score
            scores[i][1] = 50 + rand.nextInt(50); // Chemistry score
            scores[i][2] = 50 + rand.nextInt(50); // Math score
        }

        return scores;
    }

    // Method to calculate total, average, and percentage for each student
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][4]; // [0] = Total, [1] = Average, [2] = Percentage, [3] = Rounded Percentage

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2]; // Total marks
            double average = total / 3.0; // Average marks
            double percentage = (total / 300.0) * 100; // Percentage

            // Storing results in the array
            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
            results[i][3] = Math.round(percentage * 100.0) / 100.0; // Rounded percentage to 2 decimal places
        }

        return results;
    }

    // Method to display the scorecard in tabular format
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("----------------------------------------------------");
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student %d\t%d\t\t%d\t\t%d\t%.2f\t%.2f\t%.2f%%\n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    results[i][0], results[i][1], results[i][3]);
        }

        System.out.println("----------------------------------------------------");
    }

    public static void main(String[] args) {
        // Number of students
        int numStudents = 5;

        // Step 1: Generate random scores for students
        int[][] scores = generateScores(numStudents);

        // Step 2: Calculate total, average, and percentage
        double[][] results = calculateResults(scores);

        // Step 3: Display the scorecard
        displayScorecard(scores, results);
    }
}

