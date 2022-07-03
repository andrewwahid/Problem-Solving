import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LongestFamilyChain {

    public static int solve(String[] words) {
        if (words == null || words.length == 0) return 0;
        int result = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> wordsMap = new HashMap<>();

        for (String word : words) {
            wordsMap.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder current = new StringBuilder(word);
                String next = current.deleteCharAt(i).toString();
                if (wordsMap.containsKey(next) && wordsMap.get(next) + 1 > wordsMap.get(word))
                    wordsMap.put(word, wordsMap.get(next) + 1);
            }
            result = Math.max(result, wordsMap.get(word));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] words = new String[n];
        String line = null;
        for (int i = 0; i < n; i++){
            line = bufferedReader.readLine().replaceAll("\\s+$", "");
            words[i] = line;
        }

        int result = solve(words);
        System.out.println(result);

        bufferedReader.close();
    }

}
