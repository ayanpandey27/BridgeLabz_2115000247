public class SubstringOccurrences {
    public static int countSubstringOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "This is a test string and this is just a test";
        String substring = "is";
        System.out.println("Occurrences of substring: " + countSubstringOccurrences(str, substring));
    }
}

