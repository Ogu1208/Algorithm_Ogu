package 그리디;

import java.io.*;

public class Q2885_초콜릿식사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int size = 1;
        int count = 0;

        // 구매해야 하는 가장 작은 초콜릿 크기 구하기
        while (size < K) size *= 2;
        System.out.print(size);

        while (K > 0) {
//            System.out.println("K =" + K + ", " + "size = " + size);
            if (K >= size) {
                K -= size;
            } else {
                size /= 2;
                count++;
            }
//            System.out.println("K =" + K + ", " + "size = " + size + "count = " + count);
//            System.out.println("===========");
        }
        System.out.println(" " + count);
    }
}
