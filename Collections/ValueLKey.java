import java.util.*;

public class MaxValueKey {
    public static <K> K getMaxKey(Map<K, Integer> map) {
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A", 10, "B", 20, "C", 15);
        System.out.println(getMaxKey(map));
    }
}

