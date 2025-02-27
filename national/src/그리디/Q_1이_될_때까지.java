package 그리디;

import java.util.Scanner;

/**
 * N이 100억 이상 큰 수가 되는 경우를 가정했을 때 빠르게 동작하려면,
 * N이 K의 배수가 되도록 효율적으로 한번에 빼는 방식으로 해야한다.
 */

public class Q_1이_될_때까지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, K를 공백을 기준으로 구분하여 입력 받음
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지 빼기
            int target = (n / k) * k; // 나눗셈의 몫 * k
            result += (n - target);
            n = target;

            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;

            result += 1;
            n /= k;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n - 1);
        System.out.println(result);

    }
}
