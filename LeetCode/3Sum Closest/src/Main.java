import java.util.*;

public class Main {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length-1];
        int difference = Math.abs(result - target);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int start = i+1;
            int end = nums.length - 1;
            while (start < end){
                int sum = nums[start] + nums[end] + nums[i];
                if (sum > target){
                    end--;
                }else{
                    start++;
                }
                if (difference > Math.abs(sum - target)){
                    result = sum;
                    difference = Math.abs(result - target);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));

    }
}
