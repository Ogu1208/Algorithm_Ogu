package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금광 {

    /**
     * 각 열에서 최대값만 더하는 것이 불가능한 이유
     * -> 오른쪽 위, 오른쪽, 오른쪽 아래만 이동 가능하기 때문
     * dp[i][j] = array[i][j] + max(dp[i-1][j-1], dp[i][j-1], dp[i+1][j-1])
     *
     * 또한 초기값을 닮는 배열 arr없이 dp 테이블 만으로 해결 가능
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int result = 0;

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] gold = new int[N][M];
            int[][] dp = new int[N][M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    gold[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                dp[i][0] = gold[i][0];
            }

            for (int j = 1; j < M; j++) { // 열
                for (int i = 0; i < N; i++) { // 행
                    int upLeft = (i > 0) ? dp[i - 1][j - 1] : 0; // 왼쪽 위
                    int left = dp[i][j - 1]; // 왼쪽
                    int downLeft = (i + 1 < N) ? dp[i + 1][j - 1] : 0; // 왼쪽 아래

                    dp[i][j] = gold[i][j] + Math.max(upLeft, Math.max(left, downLeft));
                }
            }

            // 마지막 열에서 최대값 찾기
            for (int i = 0; i < N; i++) {
                result = Math.max(result, dp[i][M - 1]);
            }

            System.out.println(result);
        }

    }
}
