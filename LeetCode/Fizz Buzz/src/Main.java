import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean divBy3 = ((i+1) % 3) == 0;
            boolean divBy5 = ((i+1) % 5) == 0;
            result.add(divBy3 && divBy5 ? "FizzBuzz" : (divBy3 ? "Fizz" : (divBy5 ? "Buzz" : String.valueOf(i+1))));
        }
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.fizzBuzz(15).toString());
    }
}
