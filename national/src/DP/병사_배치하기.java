package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열 -> 가장 긴 감소하는 부분 수열을 구애햐 함
 * -> 병수 정보의 순서를 뒤집어 LIS를 도출
 * 모든 i <= j < i에 대하여 D[i] = max(D[i], D[j] + 1) if array[j] < array[i]
 * D[i] : i를 마지막 원소로 가지는 가장 긴 증가하는 부분수열
 */
public class 병사_배치하기 {

    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.reverse(arr); // 역순으로 정렬해서 LIS 찾기

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < N; i++) { //
            for (int j = 0; j < i; j++) {
                if (arr.get(i) > arr.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(N - max); // 열외해야 하는 최소 병사 수
    }
}
