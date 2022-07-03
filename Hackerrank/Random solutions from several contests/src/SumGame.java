import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SumGame {


    public static void solve(long A, long B){
        long start = Math.min(A, B);
        long end = Math.max(A, B);
        long result = ((end-start)+1) * (start + end) / 2;
        if (result % 2 == 0){
            System.out.println("Nasser");
            return;
        }
        System.out.println("Hoss");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine().trim();
        long A = Long.parseLong(input.split(" ")[0]);
        long B = Long.parseLong(input.split(" ")[1]);

        solve(A, B);

        bufferedReader.close();
    }
}
