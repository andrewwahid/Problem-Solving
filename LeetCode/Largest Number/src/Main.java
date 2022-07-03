import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public String largestNumber(int[] nums) {
        ArrayList<String> entries = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            entries.add(String.valueOf(nums[i]));
        }
        Collections.sort(entries, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder result = new StringBuilder();
        for(String s: entries)
            result.append(s);
        if (result.charAt(0) == '0') return "0";
        return result.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.largestNumber(new int[]{9, 0, 0, 80, 8, 800, 805, 7, 5, 4, 3, 2, 1}));
    }
}
