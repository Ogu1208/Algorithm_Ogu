package DFS_BFS;

import java.io.IOException;
import java.util.Scanner;

/**
 * 1자리인 소수 -> 2, 3, 5, 7
 * 1자리부터 DFS로 소수인 자리를 넓혀가는 문제
 * 중간 개선점 : 끝자리가 짝수인 경우 제외 가능
 */
public class Q2023_신기한소수찾기 {
    static int N;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    static void dfs(int num, int length) {
        if (length == N) {
            System.out.println(num);
            return;
        }

        for (int i = 1; i <= 9; i += 2) { // 개선 방향 : 끝자리수가 짝수인 경우 제외
            int next = num * 10 + i;

            if (isPrime(next)) {
                dfs(next, length + 1);
            }
        }
    }

    /**
     * 특정 숫자 n이 소수인지 판별
     *
     * @param n 검사할 수
     * @return true면 소수, false면 소수 아님
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;  // 0, 1은 소수 아님
        if (n == 2) return true;  // 2는 소수

        // 2부터 √n 까지만 나눠보기(에라토네스의 체)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true; // 위에서 안 걸렸으면 소수
    }
}
