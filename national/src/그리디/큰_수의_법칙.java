package 그리디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 큰_수의_법칙 {

    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 배열의 크기
        int m = sc.nextInt(); // 숫자가 더해지는 횟수
        int k = sc.nextInt(); // 연속해서 더할 수 있는 횟수
        int result = 0;

        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        int first = arrayList.get(arrayList.size() - 1);
        int second = arrayList.get(arrayList.size() - 2);

        System.out.println("first = " + first + ", second = " + second);

        if (first == second) {
            result = m * first;
        } else {
            result = ((first * k + second) * (m / (k + 1))) + (first * (m % (k + 1)));
        }

        System.out.println(result);
    }
}
