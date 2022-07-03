import java.util.HashMap;

public class Main {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        boolean negative = false;
        boolean checkNegative = true;
        for (int i = 0; i < chars.length; i++) {
            char digitChar = chars[i];
            if (digitChar == '+' || digitChar == '-'){
                if (result > 0) break;
                if (!checkNegative) return 0;
                negative = digitChar == '-';
                checkNegative = false;
                continue;
            }
            if (!Character.isDigit(digitChar)){
                if (!checkNegative) break;
                if (digitChar != ' ') break;
                continue;
            }
            int digit = digitChar - '0';
            // This number can be replaced by Integer.MAX_VALUE/10
            if ((result > 214748364) || (result == 214748364 && digit > 7)){
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = (result*10) + digit;
            checkNegative = false;
        }
        return result * (negative ? -1 : 1);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.myAtoi("123"));
    }
}
