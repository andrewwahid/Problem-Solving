import java.util.HashMap;
import java.util.Map;

public class Main {
    private boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character character = magazine.charAt(i);
            if (!characterMap.containsKey(character)){
                characterMap.put(character, 1);
            }else{
                characterMap.put(character, characterMap.get(character) + 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character character = ransomNote.charAt(i);
            if (!characterMap.containsKey(character)) return false;
            int charCount = characterMap.get(character);
            if (charCount == 0) return false;
            characterMap.put(character, charCount - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.canConstruct("aa", "ab"));
    }
}
