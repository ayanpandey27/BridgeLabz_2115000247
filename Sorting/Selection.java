public class SelectionSort {
    public static void selectionSort(double[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        double[] examScores = {85.5, 92.3, 78.0, 88.9, 90.4, 76.8};
        selectionSort(examScores);
        System.out.print("Sorted Exam Scores: ");
        for (double score : examScores) {
            System.out.print(score + " ");
        }
    }
}
