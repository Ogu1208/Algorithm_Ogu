package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9251_LCS_최장공통부분수열찾기 {

    static char[] arr1;
    static char[] arr2;
    static int[][] dp;

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

        System.out.println(dp[arr1.length][arr2.length]);
    }

    /*
        재귀를 사용하는 경우, dp = new int[arr1.length][arr2.length];

   static int lcs(int x, int y) {

        // 재귀 호출 종료 조건 - 인덱스를 벗어나는 만큼 작아지면
        if(x < 0 || y < 0) return 0;

        // 연산 되어 있지 않은 경우에만 연산을 수행
        if(dp[x][y] == null) {
            if(arr1[x] == arr2[y]) {
                // 서로 같은 문자가 발견 되었다면?
                // 이전까지의 문자열의 최적해 값이 x-1, y-1 인덱스에 있고 1을 추가
                dp[x][y] = lcs(x-1, y-1) + 1;
            } else {
                // 같은 문자가 아니라면?
                // x 방향 또는 y 방향에서 큰 값을 반영한다
                dp[x][y] = Math.max(lcs(x-1, y), lcs(x, y-1));
            }
        }

        return dp[x][y];
    }
     */
}
