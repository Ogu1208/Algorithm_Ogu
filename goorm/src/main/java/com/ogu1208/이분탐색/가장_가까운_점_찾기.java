package com.ogu1208.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장_가까운_점_찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 점의 개수
        int Q = Integer.parseInt(st.nextToken()); // 질의의 개수

        long[] NArray = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NArray[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(NArray);

        for (int i = 0; i < Q; i++) { // 가장 가까운 점 찾기
            long P = Long.parseLong(br.readLine()); // 질의로 받는 x좌표

            int start = 0;
            int end = N - 1;
            int answerIndex = 0;
            long minDistance = 1_000_000_000_000_000_000L;

            while (start <= end) {
                int mid = (start + end) / 2;
                long curDistance = Math.abs(NArray[mid] - P);

                if (curDistance < minDistance || (curDistance == minDistance && NArray[mid] < NArray[answerIndex])) {
                    answerIndex = mid;
                    minDistance = curDistance;
                }

                if (P > NArray[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            }
            sb.append(NArray[answerIndex] + "\n");
        }

        System.out.println(sb.toString());
    }
}
