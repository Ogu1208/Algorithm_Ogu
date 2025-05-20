package com.ogu1208.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    세 가수의 영향력을 X, Y, Z라고 할 때 아래 세 부등식을 만족해야 함
    * X + Y >= Z
    * X + Z >= Z
    * Y + Z >= X

    임의의 X, Y를 정한다면 (|X - Y| <= Z <= X + Y) 를 성립하는 Z를 찾으면 됨
 */
public class 섭외하기_대작전 {

    static long[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        S = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(S, 0, N);

        long  count = 0;

        /*
         * 두 수 S[i], S[j]를 먼저 고르고, 세 번째 수 S[k]를 이분 탐색으로 찾기
         *  - i는 첫 번째 수의 인덱스 → 최대 N-3까지 가능해야 함 (N-2 미만)
         *  - j는 두 번째 수의 인덱스 → 항상 i+1보다 커야 하고, 최대 N-2까지 가능해야 함 (N-1 미만)
         *  - k는 j+1 이상부터 끝까지 탐색 → Arrays.binarySearch(S, j + 1, N, sum) 사용
         */
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                long sum = S[i] + S[j];
                int idx = Arrays.binarySearch(S, j + 1, N, sum); // S[k] <= sum인 최대 k를 이분탐색으로 찾기

                if (idx < 0) { // 값을 찾지 못하면 [-(삽입할 위치) -1] 반환
                    idx = -idx - 1;
                    // idx는 sum보다 큰 수가 처음 등장하는 위치
                    // 따라서 S[k] <= sum인 개수 = (idx - 1) - (j + 1) + 1 = idx - (j + 1)
                    count += (idx - (j + 1)); // 명시적으로 0을 더해 일관성 유지 및 디버깅 용이
                } else {
                    // sum이 정확히 존재 → sum도 포함 -> idx 번째 인덱스도 포함 (+1)
                    // 개수 = idx - (j + 1) + 1
                    count += (idx - (j + 1) + 1);
                }
            }
        }

        System.out.println(count);
    }
}
