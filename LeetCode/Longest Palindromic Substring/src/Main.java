public class Main {
    public String longestPalindrome(String s) {
        int maximumLength = 0;
        int index = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int maxIterationLength = 0;
            int k = chars.length-1;
            int firstOccurrence = -1;
            while (k >= i){
                if (chars[i+maxIterationLength] == chars[k]){
                    maxIterationLength++;
                    if (maxIterationLength == 1){
                        firstOccurrence = k;
                    }
                }else{
                    maxIterationLength = 0;
                    k = Math.max(k, firstOccurrence);
                    firstOccurrence = -1;
                }
                k--;
            }
            if (maxIterationLength > maximumLength){
                maximumLength = maxIterationLength;
                index = i;
            }
        }
        return s.substring(index, index+maximumLength);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.longestPalindrome("xaabacxcabaaxcabaax"));
    }
}
