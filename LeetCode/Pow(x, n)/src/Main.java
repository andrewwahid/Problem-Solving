public class Main {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double result = myPow(x, n / 2);
        if (n % 2 == 0)
            return result*result;
        else {
            if (n > 0) return x * result * result;
            return (result * result) / x;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.myPow(2, -2));
    }
}
