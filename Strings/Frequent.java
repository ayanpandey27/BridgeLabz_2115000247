public class MostFrequentCharacter {
    public static char mostFrequentChar(String str) {
        int[] freq = new int[256];
        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }

        int maxFreq = 0;
        char mostFrequent = ' ';
        
        for (int i = 0; i < 256; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                mostFrequent = (char) i;
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {
        String input = "success";
        System.out.println("Most Frequent Character: " + mostFrequentChar(input));
    }
}

