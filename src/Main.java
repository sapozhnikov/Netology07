import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> charStat = new HashMap<>();

        for (int i = 0; i < loremIpsum.length(); i++) {
            Character currentChar = loremIpsum.charAt(i);
            if (!Character.isLetter(currentChar)) {
                continue;
            }
            if (charStat.containsKey(currentChar)) {
                Integer stat = charStat.get(currentChar);
                charStat.put(currentChar, stat + 1);
            } else {
                charStat.put(currentChar, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = charStat.entrySet();
        Map.Entry<Character, Integer> minEntry = null;
        Map.Entry<Character, Integer> maxEntry = null;
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (minEntry == null) {
                minEntry = entry;
            }
            if (maxEntry == null) {
                maxEntry = entry;
            }
            if (minEntry.getValue() > entry.getValue()) {
                minEntry = entry;
            }
            if (maxEntry.getValue() < entry.getValue()) {
                maxEntry = entry;
            }
        }
        System.out.println("Min: " + minEntry.getKey() + " : " + minEntry.getValue());
        System.out.println("Max: " + maxEntry.getKey() + " : " + maxEntry.getValue());
    }
}
