import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int size = 1_000_000;
        int target = size / 2;

        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long startTime = System.nanoTime();
        boolean arrayFound = searchInArray(array, target);
        long arrayTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        boolean hashSetFound = hashSet.contains(target);
        long hashSetTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        boolean treeSetFound = treeSet.contains(target);
        long treeSetTime = System.nanoTime() - startTime;

        System.out.println("Array Search (O(N)): " + arrayTime / 1_000_000.0 + " ms | Found: " + arrayFound);
        System.out.println("HashSet Search (O(1)): " + hashSetTime / 1_000_000.0 + " ms | Found: " + hashSetFound);
        System.out.println("TreeSet Search (O(log N)): " + treeSetTime / 1_000_000.0 + " ms | Found: " + treeSetFound);
    }

    public static boolean searchInArray(int[] array, int target) {
        for (int num : array) {
            if (num == target) return true;
        }
        return false;
    }
}

