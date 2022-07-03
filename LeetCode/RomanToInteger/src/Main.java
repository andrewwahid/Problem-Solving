import java.util.HashMap;
import java.util.Map;

public class Main {

    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('M', 1000);
        romanMap.put('D', 500);
        romanMap.put('C', 100);
        romanMap.put('L', 50);
        romanMap.put('X', 10);
        romanMap.put('V', 5);
        romanMap.put('I', 1);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            Character nextChar = i != s.length() - 1 ? s.charAt(i+1) : null;
            if (nextChar != null && romanMap.get(currentChar) < romanMap.get(nextChar)){
                result -= romanMap.get(currentChar);
            }else{
                result += romanMap.get(currentChar);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.romanToInt("LVIII"));
    }
}
