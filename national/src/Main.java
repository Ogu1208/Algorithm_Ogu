import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M, x, y, direction;
    public static int[][] map;
    public static int[][] visited;

    // 0: 북, 1: 동, 2: 남, 3: 서 (인덱스 개념)
    public static int[] dx = {-1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 1;
        int turn_time = 0;

        while (true) {

            turn_left();
            int now_x = x + dx[direction];
            int now_y = y + dy[direction];

            if (visited[now_x][now_y] == 0 && map[now_x][now_y] == 0) {
                count++;
                x = now_x;
                y = now_y;

                visited[x][y] = 1;
                turn_time = 0;
                continue;
            } else {
                turn_time += 1;
            }

            if (turn_time == 4) { // 네번 돌아서 원위치 된 경우
                now_x = x - dx[direction];
                now_y = y - dy[direction];

                if (map[now_x][now_y] == 0) { // 육지이면 뒤로 한간, 아니면 break
                    // (count세는게 아니니까 가봤는지는 체크할 필요 X)
                    x = now_x;
                    y = now_y;
                    turn_time = 0;
                }

                else break;
            }
        }

        System.out.println(count);
    }
}