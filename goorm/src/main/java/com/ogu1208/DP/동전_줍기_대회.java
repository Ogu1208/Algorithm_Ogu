package com.ogu1208.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_줍기_대회 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] coins = new int[N];
        long[] dp = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        long current = coins[0];
        long maxSum = Math.max(0, current); // 처음이 음수일 수도 있으므로

        for (int i = 1; i < N; i++) {
            current = Math.max(current + coins[i], coins[i]); // 이전 합에 연속 vs 새로 새작
            maxSum = Math.max(maxSum, current);
        }

        System.out.println(maxSum);
    }
}
