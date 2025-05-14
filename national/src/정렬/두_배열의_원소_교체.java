package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 두_배열의_원소_교체 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N개의 원소
        int K = Integer.parseInt(st.nextToken()); // 바꿔치기 연산 횟수

        Integer[] a = new Integer[N];
        Integer[] b = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            b[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(a); // a는 오름차순 정렬
        Arrays.sort(b, Collections.reverseOrder()); // b는 내림차순 정렬

        for (int i = 0; i < K; i++) {
            if (a[i] < b[i]) { // a의 원소가 b의 원소보다 작으면
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            else break; // a의 원소가 b의 원소보다 크거나 같으면 stop
        }

        int result = 0;
        for (int i : a) {
            result += i;
        }
        System.out.println(result);
    }
}
