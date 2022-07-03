import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            if (map.containsKey(search)){
                return new int[]{map.get(search), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(Arrays.toString(main.twoSum(new int[]{3, 2, 4}, 6)));
    }
}
