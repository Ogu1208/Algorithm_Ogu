package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
    연결 요소의 개수 구하기 문제 -> DFS
 */
public class Q2667_단지번호붙이기 {
    static int N, count;
    static int[][] map;
    static boolean[][] visited;
    public static ArrayList<Integer> Apartment;

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

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        Apartment = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    Apartment.add(0);
                    dfs(new Node(i, j));
                    count++;
                }
            }
        }

        Collections.sort(Apartment);
        System.out.println(count);
        for (int num : Apartment) {
            System.out.println(num);
        }
    }

    static void dfs(Node node) {
        if (visited[node.x][node.y]) return;

        visited[node.x][node.y] = true;
        Apartment.set(count, Apartment.get(count) + 1);
        for (int i = 0; i < 4; i++) {
            now_x = node.x + dirX[i];
            now_y = node.y + dirY[i];

            // 유효한 좌표이고 && 집이 있는 곳(1)이고 && 방문한 적이 없다면
            if (rangeCheck() && map[now_x][now_y] == 1 && !visited[now_x][now_y]) {
                dfs(new Node(now_x, now_y));
            }
        }
    }

    static boolean rangeCheck() {
        return now_x >= 0 && now_y >= 0 && now_x < N && now_y < N;
    }
}
