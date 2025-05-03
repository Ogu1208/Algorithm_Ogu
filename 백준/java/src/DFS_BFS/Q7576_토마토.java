package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576_토마토 {

    static int M, N;  // M : 가로, N : 세로
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;

    // 북 동 남 서
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};
    static int now_x, now_y;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 칸 개수
        N = Integer.parseInt(st.nextToken()); // 세로 칸 개수

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        // 익지 못한 토마토가 하나라도 있으면 -1 출력
        boolean hasZero = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) hasZero = true;
                max = Math.max(max, map[i][j]);
            }
        }

        System.out.println(hasZero ? -1 : max - 1);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        // 첫날에 익은 토마토 찾아 queue에 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                // 유효한 좌표이고 && 토마토가 들어 있고(-1이 아니고) && 방문한 적이 없으면
                now_x = current.x + dirX[i];
                now_y = current.y + dirY[i];

                if(rangeCheck() && map[now_x][now_y] != -1 && !visited[now_x][now_y]) {
                    queue.offer(new Node(now_x, now_y));
                    visited[now_x][now_y] = true;
                    map[now_x][now_y] = map[current.x][current.y] + 1;
                }
            }
        }
    }

    static boolean rangeCheck() {
        return now_x >= 0 && now_y >= 0 && now_x < N && now_y < M;
    }
}
