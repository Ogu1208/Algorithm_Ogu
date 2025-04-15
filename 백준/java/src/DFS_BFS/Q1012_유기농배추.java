package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 이 문제는 DFS, BFS 모두 풀이가 가능하다.
 * 상하좌우를 살피며 연결 요소의 개수를 세는 문제 -> BFS로 풀이
 * https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-1012%EB%B2%88-%EC%9C%A0%EA%B8%B0%EB%86%8D-%EB%B0%B0%EC%B6%94-%EC%9E%90%EB%B0%94
 */
public class Q1012_유기농배추 {

    static Queue<Node> queue = new LinkedList<>();
    static int[][] map;
    static boolean[][] visit;
    static int M, N, K;

    // 상하좌우
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};
    static int now_x, now_y;
    static int count;

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
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visit = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            count = 0;

            // 배추 찾기
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {

                    if(!visit[j][k] && map[j][k] == 1) {
                        // 방문한 적이 없고 배추가 심어져 있다면 지렁이 심기
                        count++;
                        bfs(k, j);
                    }
                }
            }

            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        visit[y][x] = true;
        queue.offer(new Node(x, y));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                now_x = node.x + dirX[i];
                now_y = node.y + dirY[i];

                // 좌표로서 존재하고 && 방문한 적이 없고 && 배추가 심어져 있다면
                if (rangeCheck() && !visit[now_y][now_x] && map[now_y][now_x] == 1) {
                    visit[now_y][now_x] = true;
                    queue.offer(new Node(now_x, now_y));
                }
            }
        }
    }

    static boolean rangeCheck() {
        return now_x >= 0 && now_y >= 0 && now_x < M && now_y < N;
    }
}
