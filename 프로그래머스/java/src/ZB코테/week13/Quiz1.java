package ZB코테.week13;

import java.math.BigInteger;

public class Quiz1 {
    public static int solution(String s) {
        int idx1 = -1;
        int idx2 = -1;
        int mark = 0;  // -1이면 음수
        int answer;
        BigInteger num = BigInteger.valueOf(0);
        BigInteger maxI = BigInteger.valueOf(2147483647);
        BigInteger minI = BigInteger.valueOf(-2147483648);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                mark = -1;
            }
            if (s.charAt(i) > '0' && s.charAt(i) <= '9') {
                idx1 = i;
                break;
            }
        }

        for (int i = idx1; i < s.length(); i++) {
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                idx2 = i;
                System.out.println("idx2: " + s.charAt(idx2));
                break;
            }
        }
        idx2 -= 1;

        System.out.println("idx1: " + idx1);
        System.out.println("idx2: " + idx2);

        String str = s.substring(idx1, idx2 + 1);

        if (mark == 0) {
            num = new BigInteger(str);
        } else {
            num = new BigInteger(str).multiply(new BigInteger("-1"));
        }

        System.out.println("num: " + num);


        if (num.compareTo(maxI) > 0) {
            answer = Integer.MAX_VALUE;
        } else if (num.compareTo(minI) < 0) {
            answer = Integer.MAX_VALUE;
        } else {
            answer = num.intValue();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("- 42514243zero123base"));
        System.out.println(solution("  +  00051241231004242542514243_41251243"));
    }
}
