package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q9252_LCS2 {

    static char[] arr1;
    static char[] arr2;
    static int[][] dp;
    static List<Character> subseq = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();

        dp = new int[arr1.length + 1][arr2.length + 1];

        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) { // 문자가 같으면 바로 직전까지의 최적 해 + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // 문자가 다르면 왼쪽 값 또는 위쪽 값 중 최댓값 대입
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[arr1.length][arr2.length]); // 부분 수열의 길이

        int a = arr1.length;
        int b = arr2.length;

        getText(a, b); // Top-Down 방식으로 부분수열 구하기 => 재귀
        for (int i = subseq.size() - 1; i >= 0; i--) {
            System.out.print(subseq.get(i));
        }
    }

    static void getText(int r, int c) {
        if (r == 0 || c == 0) return;

        if (arr1[r - 1] == arr2[c - 1]) {
            subseq.add(arr1[r - 1]);
            getText(r - 1, c - 1);
        } else {
            if (dp[r - 1][c] > dp[r][c - 1]) {
                getText(r - 1, c);
            } else {
                getText(r, c - 1);
            }
        }
    }
}
