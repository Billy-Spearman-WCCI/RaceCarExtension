import java.util.HashMap;
import java.util.Map;

public class Swapper {
    public static void main(String[] args) {
        allSwap(new String[]{"ab", "ac"}]);
    }

    public static String[] allSwap(final String[] strings) {
        final Map<Character, Integer> firstLetterToIndex = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            final char c = strings[i].charAt(0);
            if (firstLetterToIndex.containsKey(c)) {
                final int oldIndex = firstLetterToIndex.get(c);

                // Swap the elements at i and oldIndex
                final String temp = strings[i];
                strings[i] = strings[oldIndex];
                strings[oldIndex] = temp;

                firstLetterToIndex.remove(c);
            } else {
                firstLetterToIndex.put(c, i);
            }
        }
        return strings;
    }
}
