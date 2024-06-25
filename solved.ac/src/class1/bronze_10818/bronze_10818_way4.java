package class1.bronze_10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BufferedReader + for문 Math 비교
 * 걸린 시간 : 520ms
 */
public class bronze_10818_way4 {
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int n : arr) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        System.out.println(min + " " + max);
    }
}
