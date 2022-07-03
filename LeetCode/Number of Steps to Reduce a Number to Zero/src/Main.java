public class Main {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        int steps = 0;
        while (num > 0){
            steps += num % 2 == 0 ? 1 : 2;
            num = Math.floorDiv(num, 2);
        }
        return steps-1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.numberOfSteps(123));
    }
}
