import java.util.Scanner;

public class S14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] D = new int[N + 2];  // 오늘부터 퇴사일까지 벌 수 있는 최대 수입
        int[] T = new int[N + 1];  // 상담에 필요한 일 수
        int[] P = new int[N + 1];  // 상담을 완료했을 때 받는 수입

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) { // 일할 수 있는 날짜를 넘어가는 경우
                D[i] = D[i + 1];
            } else {
                // 일할 수 있는 날짜인 경우
                // 1. 일하지 않았을 때(DP[i + 1])
                // 2. 일 했을 때 총 벌 수 있는 금액(P[i] + DP[next])
                // 위 두 경우 중 더 큰 값을 DP에 넣어준다.
                D[i] = Math.max(D[i + 1], P[i] + D[i + T[i]]);
            }
        }

        System.out.println(D[1]);

    }

}
