package com.ogu1208.이분탐색;
import java.io.*;
import java.util.*;


public class 가장_가까운_점_찾기_최적풀이 {


    static final int MAXN = 100000;
    static long[] X = new long[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(X, 0, N); // 오름차순으로 정렬

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Q개의 질의 처리
        while (Q-- > 0) {
            long p = Long.parseLong(br.readLine()); // 질의 좌표 p 입력

            // 이진 탐색으로 p 이상인 최소 인덱스 (lower_bound)를 찾기
            int start = 0, end = N - 1;
            while (start < end) {
                int mid = (start + end) / 2;

                if (X[mid] < p) {
                    start = mid + 1; // p보다 작으면 오른쪽 탐색
                } else {
                    end = mid; // p 이상이면 왼쪽 포함 탐색
                }
            }

            // 이진 탐색 종료 후
            // start는 p 이상인 가장 작은 인덱스

            if (start == 0) {
                // 배열 가장 앞이면 왼쪽 비교 대상 없음
                bw.write(X[start] + "\n");
            } else {
                // p와 X[start] 또는 X[start - 1] 중 더 가까운 값 출력 (start - 1, P, start)
                if (Math.abs(p - X[start - 1]) <= Math.abs(p - X[start])) {
                    bw.write(X[start - 1] + "\n"); // 왼쪽이 더 가깝거나 같으면 작은 쪽 선택
                } else {
                    bw.write(X[start] + "\n"); // 오른쪽이 더 가까우면 오른쪽 선택
                }
            }
        }

        // 출력 버퍼 비우기
        bw.flush();
    }
}
