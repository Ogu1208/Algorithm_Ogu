package DP;

public class DP_Bottom_Up {

    public static long[] d = new long[100];

    public static void main(String[] args) {

        d[1] = 1;
        d[2] = 1;
        int n = 50;

        // Bottom_Up 방식은 반복문을 사용
        for (int i = 3; i < n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.println(d[n]);
    }
}
