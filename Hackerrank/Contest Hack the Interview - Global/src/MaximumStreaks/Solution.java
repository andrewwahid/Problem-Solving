package MaximumStreaks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getMaxStreaks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY toss as parameter.
     */

    public static List<Integer> getMaxStreaks(List<String> toss) {
        int maximumHeads = 0;
        int maximumTails = 0;
        String lastToss = "";
        int currentHeads = 0;
        int currentTails = 0;
        for (String face : toss) {
            if (face.equals(lastToss) || lastToss.isEmpty()){
                if (face.equals("Heads")){
                    currentHeads++;
                }else if (face.equals("Tails")){
                    currentTails++;
                }
            }else{
                if (lastToss.equals("Heads")){
                    maximumHeads = Math.max(maximumHeads, currentHeads);
                    currentHeads = 0;
                    currentTails = 1;
                }else if (lastToss.equals("Tails")){
                    maximumTails = Math.max(maximumTails, currentTails);
                    currentHeads = 1;
                    currentTails = 0;
                }
            }
            lastToss = face;
        }
        maximumHeads = Math.max(maximumHeads, currentHeads);
        maximumTails = Math.max(maximumTails, currentTails);
        List<Integer> result = new ArrayList<>();
        result.add(maximumHeads);
        result.add(maximumTails);
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tossCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> toss = IntStream.range(0, tossCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Integer> ans = Result.getMaxStreaks(toss);
        System.out.println(ans);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
