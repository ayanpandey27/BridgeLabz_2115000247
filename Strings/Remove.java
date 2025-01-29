public class RemoveCharacter {
    public static String removeCharacter(String str, char chToRemove) {
        return str.replaceAll(String.valueOf(chToRemove), "");
    }

    public static void main(String[] args) {
        String input = "Hello World";
        char chToRemove = 'l';
        System.out.println("Modified String: " + removeCharacter(input, chToRemove));
    }
}

