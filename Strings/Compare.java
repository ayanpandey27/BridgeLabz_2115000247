public class CompareStrings {
    public static String compareStrings(String str1, String str2) {
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                return "\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order";
            } else if (str1.charAt(i) > str2.charAt(i)) {
                return "\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order";
            }
        }
        
        if (str1.length() < str2.length()) {
            return "\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order";
        } else if (str1.length() > str2.length()) {
            return "\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order";
        }
        
        return "Both strings are equal.";
    }

    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";
        System.out.println(compareStrings(str1, str2));
    }
}

