public class FirstNegativeSearch {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, -5, 9, -1};
        System.out.println("First negative number index: " + findFirstNegative(numbers));
    }
}

