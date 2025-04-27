package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1932_정수삼각형 {
    static int[][] tri;
    static int[][] sumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        tri = new int[n][n];
        sumArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(sumArr[i], 0);
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sumArr[0][0] = tri[0][0];
        for (int i = 1; i < n; i++) { // 2번째 줄부터
            for (int j = 0; j <= i; j++) {
                sumArr[i][j] = tri[i][j] + sumArr[i - 1][j];

                if (j > 0)
                    sumArr[i][j] = Math.max(sumArr[i][j], tri[i][j] + sumArr[i - 1][j - 1]);
            }
        }

        int max = sumArr[n - 1][0];
        for (int i = 0; i < sumArr[n - 1].length; i++) {
            if (max < sumArr[n - 1][i]) max = sumArr[n - 1][i];
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(sumArr[i]));
//        }
        System.out.println(max);
    }
}
