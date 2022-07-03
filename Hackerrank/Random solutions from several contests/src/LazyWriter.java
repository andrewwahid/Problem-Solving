import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LazyWriter {

    public static void solve(long h, List<Long> booksLengths){
        int n = booksLengths.size();
        int min = 1;
        int max = Integer.MAX_VALUE - 1;
        int result = -1;
        while(min <= max){
            int mid = (max + min)/2;
            double sum = 0;
            for(int i = 0; i<n-1; ++i){
                sum += Math.ceil( ( (double) booksLengths.get(i)) /mid);
            }
            sum = sum + ( ( (double) booksLengths.get(n-1)) /mid);
            if(sum > h){
                min = mid+1;
            }else{
                result = mid;
                max = mid-1;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine().trim();
        long N = Long.parseLong(input.split(" ")[0]);
        long H = Long.parseLong(input.split(" ")[1]);

        List<Long> aa = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        solve(H, aa);

        bufferedReader.close();
    }
}
