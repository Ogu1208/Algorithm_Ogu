package com.ogu1208.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 해적왕_구름이 {

    static class Node implements Comparable<Node> {
        int i;
        int x;
        int y;

        public Node(int i, int x, int y) {
            this.i = i;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return this.y - o.y;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        List<Node> islands = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            islands.add(new Node(i, x, y));
        }

        Collections.sort(islands);

        int[] results = new int[N];

        for (int i = 0; i < N; i++) {
            results[islands.get(i).i] = N - i - 1;
        }

        for (int r : results) {
            System.out.println(r);
        }
    }
}
