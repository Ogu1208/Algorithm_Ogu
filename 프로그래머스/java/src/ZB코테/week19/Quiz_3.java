package ZB코테.week19;

public class Quiz_3 {
    public int solution(int[] param0) {
        int answer = 0;
        int max = param0[0];

        for (int i = 1; i < param0.length; i++) {
            if (param0[i] > max) {
                max = param0[i];
            }
        }
        answer = max - param0.length;

        return answer;
    }
}
