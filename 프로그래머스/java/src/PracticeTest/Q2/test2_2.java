package PracticeTest.Q2;

import java.util.ArrayList;
import java.util.List;

public class test2_2 {
    public static int[] solution(int[] arr) {
        List<Integer> iList = new ArrayList<>();
        iList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (iList.size() != 0 && iList.get(iList.size() - 1) != arr[i]) {
                iList.add(arr[i]);
            }
        }

        int[] answer = new int[iList.size()];
        for (int i = 0; i < iList.size(); i++) {
            arr[i] = iList.get(i).intValue();
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,1,3,3,0,1,1})); // [1,3,0,1]
        System.out.println(solution(new int[] {4,4,4,3,3})); // [4,3]
    }
}
