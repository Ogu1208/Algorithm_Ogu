package ZB코테.week6;

import java.util.Arrays;

public class Quiz_6_1 {
    public static String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        int[] num = new int[problems.length];

        String[][] answer = new String[problems.length][0];
        for (int i = 0; i < problems.length; i++) {
            for (int j = 0; j < lyrics.length; j++) {
                if (lyrics[j].startsWith(problems[i])) {
                    num[i]++;
                }
            }
            answer[i] = new String[num[i]];
        }

//        System.out.print("num 배열: ");
//        for (int n : num) {
//            System.out.print(n + " ");
//        }
//        System.out.println();

        for (int i = 0; i < problems.length; i++) {
            int cnt = 0;
            for (int j = 0; j < lyrics.length; j++) {
                if (lyrics[j].startsWith(problems[i])) {
                    answer[i][cnt++] = titles[j];
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print("answer[" + i + "]:  ");
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + ", ");
            }
            System.out.println();
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.printf("answer[%d]의 크기: %d\n", i, answer[i].length);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] lyrics = {"산다는게다그런거지누구나빈손으로와...(후략)",
                "아기상어뚜루루뚜루귀여운뚜루루뚜루...(후략)",
                "개울가에올챙이한마리꼴물꼬물헤엄치다...(후략)",
                "산다는건그런거래요힘들고아픈날도많지만...(후략)"};
        String[] titles = {"아모르파티", "아기상어", "올챙이와개구리", "산다는건"};
        String[] problems = {"산다", "아기상어", "올챙이"};
        solution(titles, lyrics, problems);
        System.out.println(Arrays.toString(solution(titles, lyrics, problems)));
    }
}
