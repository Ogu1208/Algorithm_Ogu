package com.ogu1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int MOD = 1_000_000_007;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < K; i++) { // 휴식
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

        dp[0][0] = 1; // (0, 0)으로 오는 경우의 수는 1로 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 주사위를 1 ~ 6 까지 굴려 도착
                for (int k = 1; k <= 6; k++) {
                    // (r + x, c) -> 행으로 추가 이동
                    if (i - k >= 0 && map[i - k][j] != 1) {
                        dp[i][j] = (dp[i][j] + dp[i - k][j]) % MOD;
                    }
                    // (r, c + x) -> 열으로 추가 이동
                    if (j - k >= 0 && map[i][j - k] != 1) {
                        dp[i][j] = (dp[i][j] + dp[i][j - k]) % MOD;
                    }
                }
            }
        }

        System.out.println(dp[N - 1][M - 1]);

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}