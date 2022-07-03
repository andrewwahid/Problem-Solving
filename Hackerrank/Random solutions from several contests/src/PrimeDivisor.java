import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeDivisor {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(bufferedReader.readLine().trim());
        bufferedReader.close();

        if (n == 1) {
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }

    }


}
