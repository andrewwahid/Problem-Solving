public class Main {
    public int reverse(int x) {
        int result = 0;
        while (x != 0){
            // These numbers can be replaced by Integer.MAX_VALUE/10 and Integer.MIN_VALUE/10
            if (result >= 214748365 || result <= -214748365) return 0;
            result = result*(10) + (x%10);
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.reverse(-1563847412));
    }
}
