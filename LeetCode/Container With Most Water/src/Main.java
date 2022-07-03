import java.util.Arrays;

public class Main {
    public int maxArea(int[] height) {
        int maximumArea = 0;
        int leftIndex = 0;
        int rightIndex = height.length-1;
        //
        while (leftIndex < rightIndex){
            maximumArea = Math.max(maximumArea, (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]));
            if (height[leftIndex] > height[rightIndex]){
                int currentHeight = height[rightIndex];
                while (height[rightIndex] <= currentHeight && leftIndex < rightIndex) rightIndex--;
            }else{
                int currentHeight = height[leftIndex];
                while (height[leftIndex] <= currentHeight && leftIndex < rightIndex) leftIndex++;
            }
        }
        //
        return maximumArea;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
