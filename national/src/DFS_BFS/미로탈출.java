package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * map[x][y]에 이동 칸 수를 저장(시작점은 1)
 * visited[][]는 중복 방문 ㅂ ㅏㅇ지
 * BFS는 큐로 탐색
 */
public class 미로탈출 {

    static int N, M;
    static int[][] map; // 이동한 거리 저장하기
    static boolean[][] visited;

    // 상하좌우
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};

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

        System.out.println(bfs(0, 0));
    }

    static int bfs(int startX, int startY) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int now_x = current.x + dirX[i];
                int now_y = current.y + dirY[i];

                // 맵 범위 내에 있지 않으면 패스
                if (now_x < 0 || now_y < 0 || now_x >= N || now_y >= M)
                    continue;

                // 괴물이 있는 곳이거나 방문한 적이 있다면 패스
                if (map[now_x][now_y] == 0 || visited[now_x][now_y]) continue;

                // 큐에 넣기 + 방문처리 + 거리 저장
                queue.offer(new Node(now_x, now_y));
                visited[now_x][now_y] = true;
                map[now_x][now_y] = map[current.x][current.y] + 1;
            }
        }

        return map[N - 1][M - 1];
    }
}
