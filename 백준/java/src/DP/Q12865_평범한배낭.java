package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12865_평범한배낭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의  수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 해당 물건의 무게
            int V = Integer.parseInt(st.nextToken()); // 해당 물건의 가치

            for (int j = 1; j <= K; j++) {
                if (j < W) { // K 무게의 가방에 들어갈 수 없으면
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(V + dp[i - 1][j - W], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
