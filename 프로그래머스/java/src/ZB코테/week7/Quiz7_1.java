package ZB코테.week7;

import java.util.Arrays;

public class Quiz7_1 {
    public static boolean solution(String s, String t) {
        boolean answer = true;
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        String str1 = String.valueOf(s1);
        String str2 = String.valueOf(t1);

        if (!str1.equals(str2)) {
            answer = false;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "imfinethankyou";
        String t = "atfhinemonyuki";
        System.out.println(solution(s, t));
//        System.out.println(Arrays.toString(solution(titles, lyrics, problems)));
    }
}
