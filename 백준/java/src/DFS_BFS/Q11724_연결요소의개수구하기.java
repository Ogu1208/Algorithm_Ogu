package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11724_연결요소의개수구하기 {
    public static int N, M, count;
    public static boolean[] visited;
    public static ArrayList<Integer>[] aList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        aList = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            aList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            aList[u].add(v);
            aList[v].add(u);
        }

        count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println("count = " + count);
    }

    public static void dfs(int node) {

        if (visited[node]) return;

        visited[node] = true;
        for(int i : aList[node]) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }
}