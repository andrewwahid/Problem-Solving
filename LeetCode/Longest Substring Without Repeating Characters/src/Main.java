import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charactersMap = new HashMap<>();
        int maximumLength = 0;
        int index;
        int startPosition = 0;
        char[] chars = s.toCharArray();
        for (index = 0; index < chars.length; index++) {
            char character = chars[index];
            if (charactersMap.containsKey(character)) {
                int characterPosition = charactersMap.get(character);
                if (characterPosition >= startPosition) {
                    maximumLength = Math.max(maximumLength, index - startPosition);
                    startPosition = characterPosition + 1;
                }
            }
            charactersMap.put(character, index);
        }
        maximumLength = Math.max(maximumLength, (index) - startPosition);
        return maximumLength;
    }

    /*
    // Another way that works pretty well too
    public int lengthOfLongestSubstring(String s) {
        int maximumLength = 0;
        int start = 0;
        int end = 0;
        int[] countMap = new int[128];
        //
        int counter = 0;
        while (end < s.length()){
            if (countMap[s.charAt(end)] > 0) counter++;
            countMap[s.charAt(end)]++;
            end++;
            //
            while (counter > 0){
                if (countMap[s.charAt(start)] > 1) counter--;
                countMap[s.charAt(start)]--;
                //
                start++;
            }
            maximumLength = Math.max(end - start, maximumLength);
        }
        return maximumLength;
    }*/

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.lengthOfLongestSubstring("bbbbb"));
    }
}
