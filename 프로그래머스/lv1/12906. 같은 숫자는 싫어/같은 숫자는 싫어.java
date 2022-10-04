import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> iList = new ArrayList<>();
        iList.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (iList.get(iList.size() - 1) != arr[i]) {
                iList.add(arr[i]);
            
            }
        }

        answer = new int[iList.size()];
        for (int i = 0; i < iList.size(); i++) {
            answer[i] = iList.get(i);
        }

        return answer;
    }
}