import java.util.*;

public class RotateList {
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions %= size;
        if (positions < 0) positions += size;
        List<T> rotated = new ArrayList<>(list.subList(positions, size));
        rotated.addAll(list.subList(0, positions));
        list.clear();
        list.addAll(rotated);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        rotateList(list, 2);
        System.out.println(list);
    }
}

