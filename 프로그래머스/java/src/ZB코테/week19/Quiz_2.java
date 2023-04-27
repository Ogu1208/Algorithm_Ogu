package ZB코테.week19;

import static java.lang.Character.isDigit;
import static java.lang.Character.isUpperCase;

public class Quiz_2 {
    public boolean solution(String param0) {
        boolean answer = false;
        int isNumber = 0;
        int isUpper = 0;
        if (param0.length() < 5) {
            return false;
        }

        for (Character c : param0.toCharArray()) {
            if (isDigit(c) && isNumber == 0) {
                isNumber++;
            }
            if (isUpperCase(c) && isUpper == 0) {
                isUpper++;
            }

            if (isNumber == 1 && isUpper == 1) {
                return true;
            }
        }
        return answer;

    }
}
