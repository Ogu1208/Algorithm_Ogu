package DP;

public class DP_Algorithm {

    // 피보나치 함수(Fibonacci Function)을 재귀함수로 구현
    // 하지만 단순 재귀로 구현 -> 지수 시간 복잡도

    public static int fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }

        return fibo(x - 1) + fibo(x - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibo(4));
    }
}
