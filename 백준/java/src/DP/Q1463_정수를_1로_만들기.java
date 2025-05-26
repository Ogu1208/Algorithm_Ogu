package DP;

import java.util.Scanner;

public class Q1463_정수를_1로_만들기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        // 3으로 나누어 떨어지면 3으로 나눈다
        // 2로 나누어 떨어지면 2로 나눈다
        // 1을 뺀다
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
