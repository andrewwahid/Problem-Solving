import java.util.Arrays;

public class Main {
    public int largestRectangleArea(int[] heights) {
        int maximumArea = 0;
        int[] leftBoundaries = new int[heights.length];
        int[] rightBoundaries = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int previous = i-1;
            while (previous >= 0 && heights[previous] >= heights[i]){
                previous = leftBoundaries[previous];
            }
            leftBoundaries[i] = previous;
        }
        for (int i = heights.length-1; i >= 0; i--) {
            int previous = i+1;
            while (previous < heights.length && heights[previous] >= heights[i]){
                previous = rightBoundaries[previous];
            }
            rightBoundaries[i] = previous;
        }
        System.out.println(Arrays.toString(leftBoundaries));
        System.out.println(Arrays.toString(rightBoundaries));
        //
        for(int i = 0; i < heights.length; i++){
            if (i == 5){
                System.out.println("For i="+i+", height = " + heights[i] +", right = "+rightBoundaries[i]+", left="+leftBoundaries[i]);
            }
            int width = rightBoundaries[i] - leftBoundaries[i] - 1;
            maximumArea = Math.max(maximumArea, heights[i] * width);
        }
        return maximumArea;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.largestRectangleArea(new int[]{45, 1, 2, 3, 4, 5, 2}));
    }
}
/*
public int largestRectangleArea(int[] heights) {
        int maximumArea = 0;
        for (int i = 0; i < heights.length; i++) {
            //
            int leftWidth = 0;
            int leftIndex = i - 1;
            while (leftIndex >= 0){
                if (heights[leftIndex] < heights[i]) break;
                leftWidth++;
                leftIndex--;
            }
            //
            int rightWidth = 0;
            int rightIndex = i+1;
            while (rightIndex < heights.length){
                if (heights[rightIndex] < heights[i]) break;
                rightWidth++;
                rightIndex++;
            }
            //
            maximumArea = Math.max(maximumArea, (leftWidth+rightWidth+1) * heights[i]);
        }
        return maximumArea;
    }
 */
