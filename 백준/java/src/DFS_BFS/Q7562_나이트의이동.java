package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562_나이트의이동 {

    static int count;
    static int[][] map;
    static boolean[][] visited;

    static int[] dirX = {-1, -2, -2, -1, 1, 2, 2, 1}; // 가로
    static int[] dirY = {2, 1, -1, -2, -2, -1, 1, 2}; // 세로
    static int now_x, now_y;
    static int oneSide;
    static Node start, end;

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

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            oneSide = Integer.parseInt(br.readLine());
            map = new int[oneSide][oneSide];
            visited = new boolean[oneSide][oneSide];

            st = new StringTokenizer(br.readLine());
            start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs();
            System.out.println(map[end.x][end.y]);
        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(start.x, start.y));
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == end.x && current.y == end.y) break;

            for (int i = 0; i < 8; i++) {
                // 유효한 좌표이고 && 토마토가 들어 있고(-1이 아니고) && 방문한 적이 없으면
                now_x = current.x + dirX[i];
                now_y = current.y + dirY[i];

                if (rangeCheck() && !visited[now_x][now_y]) {
                    queue.offer(new Node(now_x, now_y));
                    visited[now_x][now_y] = true;
                    map[now_x][now_y] = map[current.x][current.y] + 1;
                }
            }
        }
    }

    static boolean rangeCheck() {
        return now_x >= 0 && now_y >= 0 && now_x < oneSide && now_y < oneSide;
    }
}
