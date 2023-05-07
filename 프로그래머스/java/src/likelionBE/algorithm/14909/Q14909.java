/**
  문제
  주어진 N개의 정수 중에서 양의 정수의 개수를 출력하는 프로그램을 작성하시오.
  입력
  첫째 줄에 최대 1,000,000개의 정수가 주어진다. 입력으로 주어지는 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같다.
  출력
  첫째 줄에 양의 정수의 개수를 출력한다.
 */

import java.util.Scanner;

public class Q14909 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n > 0) cnt++;
        }

        System.out.println(cnt);
    }
}