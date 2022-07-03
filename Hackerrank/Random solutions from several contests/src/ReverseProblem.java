import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ReverseProblem {

    public static String solve(List<String> inputs, int k){
        StringBuilder result = new StringBuilder(inputs.get(0));
        int index = 1;
        //
        while (index < inputs.size()){
            String entry = inputs.get(index);
            //boolean doesMatch = result.substring(result.length()-2, result.length()).equals(entry.substring(0, 2));
            boolean doesMatch = result.charAt(result.length()-2) == entry.charAt(0) && result.charAt(result.length()-1) == entry.charAt(1);
            if (doesMatch){
                result.append(entry.charAt(2));
                if (result.length() == k) return result.toString();
            }else{
                return result.toString();
            }
            index++;
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        /*String x = "amksdfnuwelasfmowaejksalnflasxcmuasbgfkqwernsuafnjasmdfkqwheasjkbfasdmcaskdqwiheqwnflmofjasindfjklawsermqwklrnuadfhoasmxckzksnajslqlwklqpmvnjdbfjasbredywqetjrtgycmmvllxdjahjvbvzagsfqwyeojt";
        int index = 0;
        while (index < x.length() - 2){
            System.out.println(x.substring(index, index+3));
            index++;
        }*/
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String line = null;
        List<String> combinations = new ArrayList<>();
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < n-2; i++){
            line = bufferedReader.readLine().trim().replaceAll("\\s+$", "");
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

        //System.out.println(combinations);
        //
        Map<String, Integer> map = new HashMap<>();
        for (String elt : combinations) {
            System.out.println("PUTTING ->> " + elt);
            int val = 1;
            if (map.containsKey(elt))
                val = map.get(elt) + 1;
            map.put(elt, val);
        }
        List<List<String>> totalSublists = new ArrayList<>();
        while (map.size() > 0) {
            List<String> subList = new ArrayList<>();
            Iterator<String> it = map.keySet().iterator();
            int index = 0;
            while (it.hasNext()) {
                String elt = it.next();
                System.out.println("Analyzing >> " + elt);
                subList.add(index, elt);
                index++;
                if (map.get(elt) == 1) {
                    it.remove();
                } else {
                    map.put(elt, map.get(elt)-1);
                }
            }
            totalSublists.add(subList);
        }
        //
        combinations.sort(new SortComparator());
        System.out.println(combinations);
        for (int i = 0; i < totalSublists.size(); i++) {
            System.out.println(totalSublists.get(i));
        }
        //System.out.println(resultK);


        bufferedReader.close();

        String result = null;
        try {
            result = solve(combinations, n);
        } catch (Exception e) {
            System.out.println("NO");
            return;
        }
        if (result.length() != n){
            System.out.println("NO");
        }else{
            System.out.println("YES");
            System.out.println(result);
        }
        //System.out.println("NO");
    }
}

class SortComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        //if (o1.substring())
        return o1.substring(1, 3).compareTo(o2.substring(0, 2));
    }
}