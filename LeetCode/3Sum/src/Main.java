import java.util.*;

public class Main {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> positives = new HashSet<>();
        Set<Integer> negatives = new HashSet<>();
        ArrayList<Integer> positiveNums = new ArrayList<>();
        ArrayList<Integer> negativeNums = new ArrayList<>();
        ArrayList<Integer> zeroNums = new ArrayList<>();
        //
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (number == 0){
                zeroNums.add(number);
            }else if (number < 0){
                negatives.add(number);
                negativeNums.add(number);
            }else{
                positives.add(number);
                positiveNums.add(number);
            }
        }
        Collections.sort(positiveNums);
        Collections.sort(negativeNums);
        //
        if (zeroNums.size() >= 3){
            ArrayList<Integer> x = new ArrayList<>();
            x.add(0);
            x.add(0);
            x.add(0);
            result.add(x);
        }
        //
        if (!zeroNums.isEmpty()){
            for (int i = 0; i < positiveNums.size(); i++) {
                int number = positiveNums.get(i);
                if (negatives.contains(number * -1)){
                    ArrayList<Integer> x = new ArrayList<>();
                    x.add(number);
                    x.add(number * -1);
                    x.add(0);
                    result.add(x);
                }
            }
        }
        //
        for (int i = 0; i < positiveNums.size(); i++) {
            for (int k = i+1; k < positiveNums.size(); k++) {
                int target = -1 * (positiveNums.get(i) + positiveNums.get(k));
                if (negatives.contains(target)){
                    ArrayList<Integer> y = new ArrayList<>();
                    y.add(positiveNums.get(i));
                    y.add(positiveNums.get(k));
                    y.add(target);
                    result.add(y);
                }
            }
        }
        //
        for (int i = 0; i < negativeNums.size(); i++) {
            for (int k = i+1; k < negativeNums.size(); k++) {
                int target = -1 * (negativeNums.get(i) + negativeNums.get(k));
                if (positives.contains(target)){
                    ArrayList<Integer> x = new ArrayList<>();
                    x.add(negativeNums.get(i));
                    x.add(negativeNums.get(k));
                    x.add(target);
                    result.add(x);
                }
            }
        }
        //
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
