package 트리;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1991_트리순회 {
    static int N;
    static int[] left;
    static int[] right;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        left = new int[26];
        right = new int[26];

        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char lChild = st.nextToken().charAt(0);
            char rChild = st.nextToken().charAt(0);

            int idx = parent - 'A';

            if (lChild != '.') {
                left[idx] = lChild - 'A';
            }
            if (rChild != '.') {
                right[idx] = rChild - 'A';
            }
        }

        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);

        System.out.println(sb);
    }

    public static void preOrder(int node) {
        if (node == -1) return;

        sb.append((char) (node + 'A'));
        preOrder(left[node]);
        preOrder(right[node]);
    }

    public static void inOrder(int node) {
        if (node == -1) return;

        inOrder(left[node]);
        sb.append((char) (node + 'A'));
        inOrder(right[node]);
    }

    public static void postOrder(int node) {
        if (node == -1) return;

        postOrder(left[node]);
        postOrder(right[node]);
        sb.append((char) (node + 'A'));
    }
}
