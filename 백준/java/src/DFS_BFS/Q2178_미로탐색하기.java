package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178_미로탐색하기 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};

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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(map[N - 1][M - 1]);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int now_x = node.x + dirX[i];
                int now_y = node.y + dirY[i];

                // 맵에 있는 좌표인지 확인
                if (now_x < 0 || now_y < 0 || now_x >= N || now_y >= M)
                    continue;

                // 이동할 수 있는 칸(1)이고, 방문한 적이 없다면
                if (map[now_x][now_y] == 1 && !visited[now_x][now_y]) {
                    // 큐에 넣기
                    queue.offer(new Node(now_x, now_y));
                    // 방문처리 + 거리 저장
                    visited[now_x][now_y] = true;
                    map[now_x][now_y] = map[node.x][node.y] + 1;
                }
            }
        }
    }
}
