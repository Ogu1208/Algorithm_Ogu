package ZB코테.week6;

public class Quiz_6_2 {
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int cnt = 0;
            for (int j = 0; j < words.length; j++) {
                if (queries[i].charAt(0) != '*') {
                    String str = queries[i].substring(0, queries[i].length() - 1);
                    if (words[j].startsWith(str)) {
                        cnt++;
                    }
                } else {
                    String str = queries[i].substring(1);
                    if (words[j].endsWith(str)) {
                        cnt++;
                    }
                }
            }

            answer[i] = cnt;
        }


        return answer;
    }
}
