package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1931
 * 정렬 조건 잘 생각해보기
 */
public class Q1931_회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] timeTable = new int[N][2];
        int endTime = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            timeTable[i][0] = Integer.parseInt(st.nextToken());
            timeTable[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(timeTable, (t1, t2) -> {
            // 시작시간 = 끝나는 시간 인 경우도 있으므로 끝나는 시간이 같은 경우 시작시간이 빠른 순으로 정렬
            if (t1[1] == t2[1]) return t1[0] - t2[0];

            return t1[1] - t2[1]; // 끝나는 시간이 빠른 순
        });

        for (int i = 0; i < N; i++) {
            if (endTime <= timeTable[i][0]){
                endTime = timeTable[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
