import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LongestSubarray {

    public static void solve(List<Long> input, long k)
    {
        HashMap<Long, Long> sumMap = new HashMap<>();
        long sum = 0;
        long maximumLength = 0;
        for (long i = 0; i < input.size(); i++) {
            sum += input.get((int) i);
            if (sum == k) {
                maximumLength = i + 1;
            }
            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum, i);
            }
            if (sumMap.containsKey(sum - k)) {
                if (maximumLength < (i - sumMap.get(sum - k))) {
                    maximumLength = i - sumMap.get(sum - k);
                }
            }
        }
        System.out.println(maximumLength);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine().trim();
        long x = Long.parseLong(input.split(" ")[0]);
        long y = Long.parseLong(input.split(" ")[1]);

        List<Long> aa = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        solve(aa, y);

        bufferedReader.close();
    }

}
