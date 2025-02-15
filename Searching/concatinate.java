public class ConcatenateStrings {
    public static String concatenate(String[] strings) {
        StringBuffer result = new StringBuffer();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] input = {"Hello", " ", "World", "!"};
        System.out.println(concatenate(input));
    }
}

