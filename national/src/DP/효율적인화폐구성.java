package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 효율적인화폐구성 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 화폐의 갯수
        int M = Integer.parseInt(st.nextToken()); // 금액
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[M + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= M; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(dp[M] == 10001 ? -1 : dp[M]);
    }
}
