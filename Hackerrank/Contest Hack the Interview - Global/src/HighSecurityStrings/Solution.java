package HighSecurityStrings;

import java.io.*;

class Result {

    /*
     * Complete the 'getStrength' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING password
     *  2. INTEGER weight_a
     */

    public static int getStrength(String password, int weight_a) {
        int result = 0;
        weight_a = weight_a % 26;
        char[] passwordArray = password.toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int offset = passwordArray[i] - 'a';
            int weight = weight_a + (offset);
            weight = weight % 26;
            result += weight;
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String password = bufferedReader.readLine();

        int weight_a = Integer.parseInt(bufferedReader.readLine().trim());

        int strength = Result.getStrength(password, weight_a);
        System.out.println(strength);

        bufferedWriter.write(String.valueOf(strength));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
