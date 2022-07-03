import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.*;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

public class Array2D {

    public static boolean doesConditionHold(List<List<Long>> pairs, int i, int k, long max){
        long x1 = pairs.get(i).get(0);
        //
        long x2 = pairs.get(k).get(0);
        //
        long xResult = Math.abs(x1 - x2);
        if (xResult > max) return false;
        return true;
    }

    public static long calculateScore(List<List<Long>> pairs, int i, int k){
        long x1 = pairs.get(i).get(0);
        long y1 = pairs.get(i).get(1);
        //
        long x2 = pairs.get(k).get(0);
        long y2 = pairs.get(k).get(1);
        //
        long xResult = Math.abs(x1 - x2);
        return y1 + y2 + xResult;
    }

    public static long solve(List<List<Long>> pairs, long k, int startPosition) {
        int pair1Index = -1;
        int pair2Index = -1;
        long currentScore = Long.MIN_VALUE;
        boolean solutionFound = false;
        //
        for (int i = startPosition; i >= 0; i--) {
            //
            if (pair1Index == -1){
                pair1Index = i;
                continue;
            }
            if (pair2Index == -1){
                pair2Index = i;
                if (doesConditionHold(pairs, pair1Index, pair2Index, k)){
                    currentScore = calculateScore(pairs, pair1Index, pair2Index);
                    solutionFound = true;
                }
                continue;
            }
            //
            boolean holdsWith1 = doesConditionHold(pairs, i, pair1Index, k);
            boolean holdsWith2 = doesConditionHold(pairs, i, pair2Index, k);
            if (holdsWith1 && holdsWith2){
                long scoreWith1 = calculateScore(pairs, i, pair1Index);
                long scoreWith2 = calculateScore(pairs, i, pair2Index);
                if (scoreWith1 > currentScore || scoreWith2 > currentScore){
                    if (scoreWith1 > scoreWith2){
                        pair2Index = i;
                    }else{
                        pair1Index = i;
                    }
                    currentScore = calculateScore(pairs, pair1Index, pair2Index);
                    solutionFound = true;
                    continue;
                }
            }
            if (holdsWith1){
                long scoreWith1 = calculateScore(pairs, i, pair1Index);
                if (scoreWith1 > currentScore){
                    pair2Index = i;
                    currentScore = calculateScore(pairs, pair1Index, pair2Index);
                    solutionFound = true;
                    continue;
                }
            }
            if (holdsWith2){
                long scoreWith2 = calculateScore(pairs, i, pair2Index);
                if (scoreWith2 > currentScore){
                    pair1Index = i;
                    currentScore = calculateScore(pairs, pair1Index, pair2Index);
                    solutionFound = true;
                    continue;
                }
            }
            //
        }
        if (!solutionFound){
            return Long.MIN_VALUE;
        }
        //
        int newPosition = Math.min(pair1Index, pair2Index);
        long newScore = solve(pairs, k, newPosition);
        return Math.max(currentScore, newScore);
    }



    public static boolean getRandomBoolean() {
        return Math.random() > 0.1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine().trim();
        int n = Integer.parseInt(input.split(" ")[0]);
        long k = Long.parseLong(input.split(" ")[1]);

        List<List<Long>> pairs = new ArrayList<>();
        TempRandomness currentX = new TempRandomness(0);
        IntStream.range(0, n).forEach(i -> {
            Long x = currentX.x;
            Long y = ThreadLocalRandom.current().nextLong(n-1);
            if (getRandomBoolean()) currentX.x++;
            pairs.add(LongStream.of(x, y).boxed().collect(toList()));
            /*try {
                pairs.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Long::parseLong)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }*/
        });

        long x = solve(pairs, k,  pairs.size()-1);
        System.out.println(x);

        bufferedReader.close();
    }
}

class TempRandomness {
    long x = 0;

    public TempRandomness(long x) {
        this.x = x;
    }
}
