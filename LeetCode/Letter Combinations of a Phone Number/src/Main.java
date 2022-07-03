import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    final char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
            {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) return new ArrayList<String>();
        //
        ArrayList<String> result = new ArrayList<>();
        dfs(0, digits.length(), new StringBuilder(), result, digits);
        //
        return result;
    }

    public void dfs(int position, int length, StringBuilder word, ArrayList<String> result, String digits){
        if (position == length){
            result.add(word.toString());
        }else{
            char[] currentMapping = map[Character.getNumericValue(digits.charAt(position))];
            for (int i = 0; i < currentMapping.length; i++) {
                dfs(position+1, length, new StringBuilder(word).append(currentMapping[i]), result, digits);
            }
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.letterCombinations("29"));
    }
}
