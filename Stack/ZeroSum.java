import java.util.*;

class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] nums) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }
            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -3, 3, 1, -4, 2, -2};
        List<int[]> subarrays = findZeroSumSubarrays(nums);

        for (int[] subarray : subarrays) {
            System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
        }
    }
}

