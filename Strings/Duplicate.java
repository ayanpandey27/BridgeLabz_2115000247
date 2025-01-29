public class RemoveDuplicates {
    public static String removeDuplicates(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (result.indexOf(ch) == -1) { // If character is not already in result
                result += ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "programming";
        System.out.println("Original String: " + input);
        System.out.println("String after removing duplicates: " + removeDuplicates(input));
    }
}

