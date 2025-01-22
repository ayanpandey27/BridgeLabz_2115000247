public class Pen {
    public static void main(String[] args) {
        // Total pens and number of students
        int totalPens = 14;
        int numberOfStudents = 3;

        // Calculate pens per student and remaining pens
        int pensPerStudent = totalPens / numberOfStudents;
        int remainingPens = totalPens % numberOfStudents;

        // Output the result
        System.out.printf("The Pen Per Student is %d and the remaining pen not distributed is %d\n", 
                          pensPerStudent, remainingPens);
    }
}

