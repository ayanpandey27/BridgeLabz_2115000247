public class InsertionSort {
    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];
            int j = i - 1;
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }
            employeeIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIds = {103, 45, 67, 89, 12, 34};
        insertionSort(employeeIds);
        System.out.print("Sorted Employee IDs: ");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
    }
}

