package DP;

import java.util.Scanner;

public class Q14501_퇴사_준비하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] DP = new int[N + 2]; // i번째 날부터 퇴사일까지 벌 수 있는 최대 수입
        int[] T = new int[N + 1]; // 상담을 완료하는 데 걸리는 시간
        int[] P = new int[N + 1]; // 받을 수 있는 금액

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) { // 일할 수 있는 기간을 벗어나는 경우
                DP[i] = DP[i + 1];
            } else {
                DP[i] = Math.max(DP[i + 1], P[i] + DP[i + T[i]]);
            }
        }

        System.out.println(DP[1]);
    }
}
