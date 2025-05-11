package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2583_영역구하기 {

    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> area;

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
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        // 전체 영역을 돌며 DFS 실행
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x] && map[y][x] == 0) {
                    int result = dfs(x, y);
                    area.add(result);
                }
            }
        }

        Collections.sort(area);
        System.out.println(area.size());
        for (int a : area) {
            System.out.print(a + " ");
        }

    }

    // DFS: 현재 위치에서 시작하여 연결된 영역 크기 반환
    public static int dfs(int x, int y) {
        visited[y][x] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int now_x = x + dirX[i];
            int now_y = y + dirY[i];

            if (now_x >= 0 && now_x < N && now_y >= 0 && now_y < M) {
                if (!visited[now_y][now_x] && map[now_y][now_x] == 0) {
                    cnt += dfs(now_x, now_y);
                }
            }
        }

        return cnt;
    }
}
