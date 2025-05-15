package com.ogu1208.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 이진수_정렬 {

    static class Node implements Comparable<Node> {

        int decimal;
        int binaryCount;

        public Node(int decimal, int binaryCount) {
            this.decimal = decimal;
            this.binaryCount = binaryCount;
        }

        @Override
        public int compareTo(Node o) {
            if (this.binaryCount == o.binaryCount) {
                return o.decimal - this.decimal;
            } else {
                return o.binaryCount - this.binaryCount;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Node> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int decimal = Integer.parseInt(st.nextToken());
            int binaryCount = Integer.bitCount(decimal);

            arr.add(new Node(decimal, binaryCount));
        }

        Collections.sort(arr);

        System.out.println(arr.get(K - 1).decimal);
    }
}
