import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static int solution(int n, int m) {
        int answer = 0;
        for (int i = n; i <= m; i++) {
            String s = Integer.toString(i);
            int start = 0;
            int end = s.length() - 1;

            if(i <= 9) {
                answer++;
                continue;
            }

            while (true) {
                if(s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                    if(start >= end) {
                        answer++;
                        break;
                    }
                } else {
                    break;
                }

            }

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 100)); // 18
        System.out.println(solution(100, 300)); // 20
    }


}
