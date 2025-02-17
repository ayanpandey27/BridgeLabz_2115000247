import java.util.*;
public class SearchTime {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        int target = 100;
        Random ran = new Random();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            arr[i] = ran.nextInt(1000);
        }
        long start = System.nanoTime();
        int linearIndex = Linear(arr, target);
        long lineartime = System.nanoTime() - start;
        Arrays.sort(arr);
        long start1 = System.nanoTime();
        int binaryIndex = Binary(arr, target);
        long binarytime = System.nanoTime() - start1;
        System.out.println(lineartime);
        System.out.println(binarytime);
    }

    public static int Linear(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int Binary(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
