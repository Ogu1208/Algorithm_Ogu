package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미_전사 {

    // 1. 최적 부분 구조 : i-1번째, i-2번째 + 현재 최적 해 비교
    // 2.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1, 3, 1, 5
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }

        System.out.println(dp[N-1]);
    }
}
