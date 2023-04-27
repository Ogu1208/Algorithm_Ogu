package ZB코테.week19;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Quiz_1 {
    public static boolean solution(String s, String t) {
        boolean answer = true;
        String[] arr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) + "";
        }
        Set<String> set = new HashSet<>(Arrays.asList(arr));

        for (int i = 0; i < t.length(); i++) {
            if (!set.contains(t.charAt(i) + "")) {
                return false;
            }

            set.remove(t.charAt(i) + "");
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdef", "efabcd"));
        System.out.println(solution("김천지는구두쇠", "두쇠구는김천지"));

    }

}
