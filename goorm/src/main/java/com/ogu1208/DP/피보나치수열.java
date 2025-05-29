package com.ogu1208.DP;

import java.util.Scanner;

public class 피보나치수열 {

    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        System.out.println(dp[N-1]);
    }
}
