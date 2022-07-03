import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ReverseProblemOld {
    static boolean solutionFound = false;
    static List<String> requiredCombinations = new ArrayList<>();

    static String generateNewString(String current, String substring){
        String result = "";
        if (current.contains(substring)) return null;
        boolean frontMatch = current.substring(0, 2).equals(substring.substring(1, 3));
        if (frontMatch){
            result = substring.charAt(0) + result;
        }else{
            boolean backMatch = current.substring(current.length()-2, current.length()).equals(substring.substring(0, 2));
            if (backMatch){
                result += substring.charAt(2);
            }else{
                frontMatch = current.charAt(0) == substring.charAt(2);
                if (frontMatch) {
                    result = substring.substring(0, 2) + result;
                }else{
                    backMatch = current.charAt(current.length()-1) == substring.charAt(2);
                    if (backMatch) {
                        result += substring.substring(0, 2);
                    }else{

                    }
                }
            }
        }
        return null;
    }


    static void bfs(int k){
        Set<String> explored = new HashSet<String>();
        Queue<String> frontier = new LinkedList<String>();
        frontier.add("");
        while (!frontier.isEmpty()){
            String currentState = frontier.remove();
            explored.add(currentState);
            if (currentState.length() == k){
                reallySolve(currentState);
                if (solutionFound) break;
                continue;
            }
            for (int i = 0; i < requiredCombinations.size(); i++) {
                String newState = currentState;
                if (currentState.isEmpty()){
                    newState += requiredCombinations.get(i);
                }else{

                }
                if (explored.contains(newState)) continue;
                frontier.add(newState);
                explored.add(newState);
            }
        }
        if (solutionFound) return;
        System.out.println("NO");
    }

    static boolean reallySolve(String input){
        boolean passed = true;
        for (int k = 0; k < requiredCombinations.size(); k++) {
            if (!input.contains(requiredCombinations.get(k))){
                passed = false;
                break;
            }
        }
        if (passed){
            System.out.println("YES");
            System.out.println(input);
            solutionFound = true;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String line = null;
        System.out.println(n-2);
        for (int i = 0; i < n-2; i++){
            line = bufferedReader.readLine().replaceAll("\\s+$", "");
            requiredCombinations.add(line);
        }

        Set<Character> visitedChars = new HashSet<>();
        char[] allowedChars = new char[256];
        int currentIndex = 0;
        for (int i = 0; i < requiredCombinations.size(); i++) {
            char[] entryChars = requiredCombinations.get(i).toCharArray();
            for (int k = 0; k < entryChars.length; k++) {
                if (visitedChars.contains(entryChars[k])) continue;
                visitedChars.add(entryChars[k]);
                allowedChars[currentIndex] = entryChars[k];
                currentIndex++;
            }
        }

        System.out.println("Started");
        //bfs(allowedChars, n);

        bufferedReader.close();
    }

}
