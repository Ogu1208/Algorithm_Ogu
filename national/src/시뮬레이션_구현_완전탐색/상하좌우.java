package 시뮬레이션_구현_완전탐색;

import java.util.Scanner;

/**
 * p.110
 * 여행가는 N*N 크기의 정사각형 공간 위에 서있다. 이 공간은 1 x 1 크기의 정사각형으로 나누어져 있다.
 * 가장 외쪽 위 좌표는 (1, 1)이며, 가장 오른쪽 아래 좌표는 (N, N)에 해당한다.
 */
public class 상하좌우 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N 입력받기
        int n = sc.nextInt();
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1;

        // L, R, U, D에 따른 이동 방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            // 이동 수행
            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }
}
