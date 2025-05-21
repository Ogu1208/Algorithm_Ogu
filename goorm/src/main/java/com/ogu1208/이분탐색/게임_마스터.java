package com.ogu1208.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임_마스터 {

    static long MAX = 1_000_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken()); // 현재까지 게임을 진행한 횟수
        long M = Long.parseLong(st.nextToken()); // 현재까지 승리한 횟수

        int curRate = (int) (M * 100 / N);
        int goalRate = curRate + 1;

        long start = 1;
        long end = MAX - 1;
        long result = MAX;

        while (start <= end) {
            long mid = (start + end) / 2;
            int rate = (int) ((M + mid) * 100 / (N + mid));

            if (rate >= goalRate) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (result == MAX) {
            System.out.println("X");
        } else {
            System.out.println(result);
        }
    }
}
