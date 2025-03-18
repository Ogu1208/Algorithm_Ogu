package 그리디;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q11399_ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int result = 0;
        int sum = 0;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            sum += pq.poll();
            result += sum;
        }

        System.out.println(result);
    }
}
