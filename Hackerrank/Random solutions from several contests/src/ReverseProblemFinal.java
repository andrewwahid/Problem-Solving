import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ReverseProblemFinal {

    public static void _removeFromMaps(String word, int wordIndex, HashMap<String, TreeSet<Integer>> startsMap, HashMap<String, TreeSet<Integer>> endsMap){
        String start = word.substring(0, 2);
        String end = word.substring(1, 3);
        if (startsMap.containsKey(start)){
            TreeSet<Integer> indexes = startsMap.get(start);
            indexes.remove(wordIndex);
            if (indexes.isEmpty()){
                startsMap.remove(start);
            }
        }
        if (endsMap.containsKey(end)){
            TreeSet<Integer> indexes = endsMap.get(end);
            indexes.remove(wordIndex);
            if (indexes.isEmpty()){
                endsMap.remove(end);
            }
        }
    }

    public static void solve(int startIndex, List<String> combinations, HashMap<String, TreeSet<Integer>> startsMap, HashMap<String, TreeSet<Integer>> endsMap, int k){
        String _startWord = combinations.get(startIndex);
        StringBuilder result = new StringBuilder(_startWord);
        _removeFromMaps(_startWord, startIndex, startsMap, endsMap);
        //
        while (!startsMap.isEmpty()){
            //System.out.println(result);
            String start = result.substring(0, 2);
            String end = result.substring(result.length()-2, result.length());
            if (startsMap.containsKey(end)){
                int index = startsMap.get(end).last();
                String _word = combinations.get(index);
                result.append(_word.charAt(2));
                _removeFromMaps(_word, index, startsMap, endsMap);
            }else if (endsMap.containsKey(start)){
                int index = endsMap.get(start).last();
                String _word = combinations.get(index);
                result.insert(0, _word.charAt(0));
                _removeFromMaps(_word, index, startsMap, endsMap);
            }else{
                System.out.println("NO");
                return;
            }
        }
        if (result.length() == k){
            System.out.println("YES");
            System.out.println(result);
        }else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        //
        HashMap<String, TreeSet<Integer>> startsMap = new HashMap<>();
        HashMap<String, TreeSet<Integer>> endsMap = new HashMap<>();
        //
        List<String> combinations = new ArrayList<>();
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < n-2; i++){
            String line = bufferedReader.readLine().trim().replaceAll("\\s+$", "");
            combinations.add(line);
            characters.add(line.charAt(0));
            characters.add(line.charAt(1));
            characters.add(line.charAt(2));
        }
        if (characters.size() > n){
            System.out.println("NO");
            return;
        }
        if (n <= 2){
            System.out.println("NO");
            return;
        }
        int currentMax = Integer.MIN_VALUE;
        int startIndex = 0;
        for (int i = 0; i < combinations.size(); i++) {
            String word = combinations.get(i);
            String start = word.substring(0, 2);
            String end = word.substring(1, 3);
            if (startsMap.containsKey(start)){
                TreeSet<Integer> tmpIndexes = startsMap.get(start);
                tmpIndexes.add(i);
                if (tmpIndexes.size() > currentMax){
                    startIndex = i;
                    currentMax = tmpIndexes.size();
                }
            }else{
                TreeSet<Integer> tmpIndexes = new TreeSet<>();
                tmpIndexes.add(i);
                startsMap.put(start, tmpIndexes);
            }
            if (endsMap.containsKey(end)){
                TreeSet<Integer> tmpIndexes = endsMap.get(end);
                tmpIndexes.add(i);
                if (tmpIndexes.size() > currentMax){
                    startIndex = i;
                    currentMax = tmpIndexes.size();
                }
            }else{
                TreeSet<Integer> tmpIndexes = new TreeSet<>();
                tmpIndexes.add(i);
                endsMap.put(end, tmpIndexes);
            }
        }
        /*System.out.println(startsMap);
        System.out.println(endsMap);
        System.out.println(startIndex);*/
        solve(startIndex, combinations, startsMap, endsMap, n);
    }
}
