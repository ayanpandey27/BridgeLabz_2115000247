public class ToggleCase {
    public static String toggleCase(String str) {
        StringBuilder result = new StringBuilder();
        
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(Character.toUpperCase(ch));
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hello World";
        System.out.println("Toggled String: " + toggleCase(input));
    }
}

