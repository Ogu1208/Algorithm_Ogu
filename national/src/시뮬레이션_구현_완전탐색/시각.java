package 시뮬레이션_구현_완전탐색;

import java.util.Scanner;

public class 시각 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (check(i, j, k)) count++;
                }
            }
        }

        System.out.println(count);
    }

    // 특정 시각 안에 3이 포함되어있는지 확인
    public static boolean check(int h, int m, int s) {
        return h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3;
    }
}
