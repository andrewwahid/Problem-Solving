import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class GoodArray {

    public static void solve(List<Long> input) {
        int i = 0, n = input.size();
        for (int j = 0; j < n; ++j, ++i) {
            input.set(i, input.get(j));
            if (i > 0 && input.get(i - 1).equals(input.get(i))) // count = 2
                i -= 2;
        }
        System.out.println(i);
        for (int k = 0; k < i; k++) {
            System.out.printf("%d ", input.get(k));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> aa = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        solve(aa);

        bufferedReader.close();
    }
}
