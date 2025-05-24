package DP;

import java.util.Scanner;

public class _1로만들기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        // 5로 나누어 떨어지면 5로 나누기
        // 3으로 나누어 떨어지면 3으로 나누기
        // 2로 나누어 떨어지면 2로 나누기
        // X에서 1 빼기
        // 26 -> 25 -> 5 -> 1

        // 최적 부분 구조 + 중복
        // 5로 나누는 것 보다 다른 연산을 적절히 섞는 것이 더 최소값일 수 있음 -> 그리디가 아닌 이유
        // 26에서 1을 빼는 것이 아닌 2로 나누는 연산을 했다면 최적의 답을 찾지 못함

        for (int i = 2; i <= N; i++) {
            // 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어진다면
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어진다면
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            // 5로 나누어 떨어진다면
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
