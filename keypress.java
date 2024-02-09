import java.util.*;

public class keypress {

    public int keypress(String s) {
        // Frequency map to count occurrences of each character
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Create a list of characters sorted by their frequencies in descending order
        List<Character> charsSortedByFrequency = new ArrayList<>(charFrequency.keySet());
        charsSortedByFrequency.sort((a, b) -> charFrequency.get(b) - charFrequency.get(a));

        // Mapping characters to buttons (1 to 9, 10 to 18, 19 to 27)
        Map<Character, Integer> buttonMapping = new HashMap<>();
        int buttonIndex = 1;

        // Assign characters to buttons according to keypress requirements
        for (char c : charsSortedByFrequency) {
            buttonMapping.put(c, buttonIndex );
            buttonIndex++;
        }

        // Calculate total keypresses based on character mappings
        int totalKeypresses = 0;
        for (char c : s.toCharArray()) {
            int buttonNumber = buttonMapping.get(c);
            totalKeypresses += (buttonNumber <= 9 ? 1 : (buttonNumber <= 18 ? 2 : 3));
        }

        return totalKeypresses;
    }

    public static void main(String[] args) {
        keypress solution = new keypress();
        String s = "abcdefghijkl";
        int result = solution.keypress(s);
        System.out.println("Keypresses needed for '" + s + "': " + result); // Output: 5
    }
}
