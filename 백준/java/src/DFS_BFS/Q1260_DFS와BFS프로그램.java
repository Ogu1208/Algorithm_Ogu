package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제 조건 꼼꼼히 읽기..
 * 노드가 여러개일 경우 노드 번호가 작은 것을 먼저 방문
 */

public class Q1260_DFS와BFS프로그램 {

    static int N, M, V;
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u].add(v);
            A[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
//
        dfs(V);
        System.out.println();
//        System.out.println("dfs끝난 후 " + Arrays.toString(visited));
        Arrays.fill(visited, false);
//        System.out.println("false로 초기화 후 : " + Arrays.toString(visited));
        bfs(V);
    }

    static void dfs(int start) {
        if (visited[start]) return;

        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i < A[start].size(); i++) {
            int check = A[start].get(i);
            dfs(check);
        }
    }

    static void bfs(int start) {
        // 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            System.out.print(node + " ");

            for (int i = 0; i < A[node].size(); i++) {
                int check = A[node].get(i);
                if (!visited[check]) { // 방문하지 않았으면
                    visited[check] = true;
                    queue.offer(check);
                }
            }
        }
    }
}
