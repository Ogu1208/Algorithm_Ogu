package ZB코테.week6;

public class Quiz_6_3 {
    public static String[][] solution(String[] words, String[] queries) {
        int[] num = new int[queries.length];
        String[][] answer = new String[queries.length][0];

        for (int i = 0; i < queries.length; i++) {
            String str = queries[i].substring(0,queries[i].indexOf("?"));
            System.out.println(str);
            for (int j = 0; j < words.length; j++) {
                if (words[j].startsWith(str) && words[j].length() == queries[i].length()) {
                    num[i]++;
                }
            }
            answer[i] = new String[num[i]];
        }

        System.out.print("num 배열: ");
        for (int n : num) {
            System.out.print(n + " ");
        }
        System.out.println();

        for (int i = 0; i < queries.length; i++) {
            String str = queries[i].substring(0,queries[i].indexOf("?"));
            int cnt = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[j].startsWith(str) && words[j].length() == queries[i].length()) {
                    answer[i][cnt++] = words[j];
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
        return answer;
    }


    public static void main(String[] args) {
        String[] words = {"hello", "hear", "hell", "good", "goose", "children", "card", "teachable"};
        String[] queries = {"he??", "g???", "childre?", "goo????", "?"};
        solution(words, queries);
//        System.out.println(Arrays.toString(solution(titles, lyrics, problems)));
    }
}
