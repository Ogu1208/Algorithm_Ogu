import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int count = 0;
        int[] arr = d.clone();
        Arrays.sort(arr);

        for (int item : arr) {
            if (count + item > budget)
                break;
            count += item;
            answer++;
        }
        return answer;
    }
}