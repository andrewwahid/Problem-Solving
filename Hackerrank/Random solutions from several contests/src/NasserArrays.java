import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NasserArrays {

    public static void solve(List<Integer> input){
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) < 0){
                input.set(i, input.get(i)+1);
            }
        }
        String x = input.stream().map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> aa = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        solve(aa);

        bufferedReader.close();
    }
}
