import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        int minimum = Integer.MAX_VALUE;
        int minStart = 0;
        //
        int [] countMap = new int[128];
        for (char c : t.toCharArray()) {
            countMap[c]++;
        }
        //
        int counter = t.length();
        while (end < s.length()){
            if (countMap[s.charAt(end)] > 0) counter--;
            countMap[s.charAt(end)]--;
            end++;
            //
            while (counter == 0){
                if (end - start <= minimum){
                    minimum = end - start;
                    minStart = start;
                }
                countMap[s.charAt(start)]++;
                if (countMap[s.charAt(start)] > 0) counter++;
                //
                start++;
            }
        }
        return minimum == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minimum);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.minWindow("ADOBECODEBANC", "ABC"));
    }
}
