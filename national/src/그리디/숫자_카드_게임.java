package 그리디;

import java.util.Scanner;

/**
 * 1. 각 행에서 가장 작은 수 찾기
 * 2. 가장 작은 수들 중에서 가장 큰 수의 행을 고르기
 */
public class 숫자_카드_게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int result = 0;

        // 한 줄씩 입력받아 확인 (굳이 배열을 만들 필요 X)
        for (int i = 0; i < m; i++) {
            // 각 행에서 가장 작은 수 찾기
            int min = 10001;
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                min = Math.min(min, x);
            }

            // 가장 작은 수 들 중에서 가장 큰 수 찾기
            result = Math.max(result, min);
        }

        System.out.println(result);
    }
}
