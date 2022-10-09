import java.util.Arrays;
class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        int[][] map3 = new int[n][n];

        for (int i = 0; i < map1.length; i++) {
            int num = arr1[i];
            for (int j = n - 1; j >= 0; j--) {
                map1[i][j] = num % 2;
                num /= 2;
            }
        }

        for (int i = 0; i < map2.length; i++) {
            int num = arr2[i];
            for (int j = n - 1; j >= 0; j--) {
                map2[i][j] = num % 2;
                num /= 2;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map1[i][j] == 1 || map2[i][j] == 1) {
                    map3[i][j] = 1;
                } else {
                    map3[i][j] = 0;
                }

            }
        }


        for (int i = 0; i < n; i++) {
            answer[i] = "";
            for (int j = 0; j < n; j++) {
                if (map3[i][j] == 1) {
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(answer[i]);
        }

        return answer;
    }
}