package 그리디;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 첫 번째 풀이 : Scanner - 시간 : 2780ms (sc.nextInt()를 N^2번 호출하기 때문)
 * 2. 2번째 풀이 : BufferedReader - 시간 : 804ms (readLine()을 N번 호출하고, StringTokenizer로 파싱)
 */

public class Q2075_N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < N-1; i++) {
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}
