package 시뮬레이션_구현_완전탐색;

import java.util.Scanner;

public class 게임_개발 {
    public static int N, M, x, y, direction;
    public static int[][] d = new int[50][50]; // 방문한 위치 저장
    public static int[][] arr = new int[50][50]; // 전체 맵

    // 북, 동, 남, 서
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    // 왼쪽으로 회전
    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();
        d[x][y] = 1; // 현재 좌표 방문 처리

        // 전체 맵 입력받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 시뮬레이션
        int cnt = 1;
        int turn_time = 0;

        while (true) {
            // 왼쪽으로 회전
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            if (d[nx][ny] == 0 && arr[nx][ny] == 0) { // 가보지 않았고 육지인 경우
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt += 1;
                turn_time = 0;
                continue;
            } else {
                // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
                turn_time += 1;
            }
            // 네 방향 모두 갈 수 없는 경우
            if (turn_time == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];
                // 뒤로 갈 수 있다면 이동하기
                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    turn_time = 0;
                }
                // 뒤가 바다로 막혀있는 경우
                else break;
            }
        }
    }
}
