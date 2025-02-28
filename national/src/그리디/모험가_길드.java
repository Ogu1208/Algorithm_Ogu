package 그리디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 모험가_길드 {

    public static int n;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }
        Collections.sort(arrayList);

        int result = 0; // 총 그룹 수
        int count = 0;
        for (int i = 0; i < n; i++) { // 공포도가 낮은 사람부터 그룹 결성
            count += 1; // 현재 그룹에 해당 모험가 포함시키기
            if (count >= arrayList.get(i)) {
                result += 1;
                count = 0;
            }
        }

        System.out.println(result);
    }
}
