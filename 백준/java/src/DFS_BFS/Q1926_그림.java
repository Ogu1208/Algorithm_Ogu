package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1926_그림 {

    static int N, M, count;  // N : 세로, M : 가로
    static int[][] map;
    static boolean[][] visited;
    public static ArrayList<Integer> paintings;
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
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new int[N][M];
        visited = new boolean[N][M];
        paintings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) { // 그림이고 방문한 적이 없으면
                    paintings.add(0);
                    dfs(new Node(i, j));
                    count++;
                }
            }
        }

        Collections.sort(paintings);
        System.out.println(count);
        System.out.println(paintings.isEmpty() ? 0 : paintings.get(paintings.size() - 1)); // 그림이 하나도 없을 경우
    }

    static void dfs(Node node) {
        if (visited[node.x][node.y]) return;

        visited[node.x][node.y] = true;
        paintings.set(count, paintings.get(count) + 1);
        for (int i = 0; i < 4; i++) {
            now_x = node.x + dirX[i];
            now_y = node.y + dirY[i];

            // 유효한 좌표이고 && 그림이고 && 방문한 적이 없다면
            if (rangeCheck() && map[now_x][now_y] == 1 && !visited[now_x][now_y]) {
                dfs(new Node(now_x, now_y));
            }
        }
    }

    static boolean rangeCheck() {
        return now_x >= 0 && now_y >= 0 && now_x < N && now_y < M;
    }
}
