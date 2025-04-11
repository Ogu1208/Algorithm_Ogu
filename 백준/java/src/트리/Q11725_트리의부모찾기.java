package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11725_트리의부모찾기 {

    static int N;
    static List<Integer>[] tree;
    static int[] parentResult;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        parentResult = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 무방향 그래프이므로 서로 연결
            tree[a].add(b);
            tree[b].add(a);
        }

//        bfs(1);
        dfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parentResult[i]);
        }
    }

    static void bfs(int root) {
        visited[root] = true;
        Queue<Integer> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int parentNode = queue.poll();

            for (int childNode : tree[parentNode]) {
                if (!visited[childNode]) {
                    visited[childNode] = true;
                    queue.offer(childNode);
                    parentResult[childNode] = parentNode;
                }
            }
        }
    }

    static void dfs(int parentNode) { // 재귀 함수
        visited[parentNode] = true;

        for (int childNode : tree[parentNode]) {
            if(!visited[childNode]) {
                visited[childNode] = true;
                parentResult[childNode] = parentNode;
                dfs(childNode);
            }
        }
    }
}
