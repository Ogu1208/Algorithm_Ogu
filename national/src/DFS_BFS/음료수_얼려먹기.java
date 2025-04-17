package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 index 변수 실수, rangeCheck 두번째에 찾음 한번에 떠올리자
 * 백준 Q1012 유기농 배추 문제와 똑같음
 */
public class 음료수_얼려먹기 {

    static int N, M, count, nx, ny;
    static boolean[][] visited;
    static int[][] map;

    // 상하좌우
    static int[] dirx = {-1, 1, 0, 0};
    static int[] diry = {0, 0, -1, 1};

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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    count++;
                    dfs(new Node(i, j));
                }
            }
        }

        System.out.println("count = " + count);
    }

    public static void dfs(Node curNode) {
        if (visited[curNode.x][curNode.y]) return;

        visited[curNode.x][curNode.y] = true;
        // 상하좌우 돌면서 dfs 재귀 방문처리
        for (int i = 0; i < 4; i++) {
            nx = curNode.x + dirx[i];
            ny = curNode.y + diry[i];

            if (rangeCheck() && map[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(new Node(nx, ny));
            }
        }
    }

    static boolean rangeCheck() {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }
}
