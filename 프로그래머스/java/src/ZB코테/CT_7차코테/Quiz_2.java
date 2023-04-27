package ZB코테.CT_7차코테;

import java.util.HashMap;

public class Quiz_2 {

    // HashMap(Integer, Integer>
    // 시간 : O(n), 공간 : O(n)
    public static int solution(int[] votes) {
        if (votes.length == 0 || votes == null) {
            return 0;
        }
        int answer = 0;
        int cnt = 0;
        int size = votes.length;
        HashMap<Integer, Integer> voteSet = new HashMap<>();


        for (int n : votes) {
            voteSet.put(n, voteSet.getOrDefault(n, 0) + 1);
            cnt++;
            if (voteSet.get(n) > size / 2) {
                answer = n;
                break;
            }
        }
        return answer;
    }


    // 과반수 득표 알고리즘
    // 시간 : O(n), 공간 : O(1)
   public static int majorityElement(int[] nums) {
        int answer = 0;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                answer = num;
                cnt++;
            } else if (answer == num) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] votes = {4, 3, 2, 3, 3, 3, 3, 1, 2, 2, 3};
        System.out.println(solution(votes));

        int[] votes2 = {1, 4, 2, 2, 2, 2, 2, 3, 1};
        System.out.println(solution(votes2));

        System.out.println();
        System.out.println(majorityElement(votes));
        System.out.println(majorityElement(votes2));

    }
}
