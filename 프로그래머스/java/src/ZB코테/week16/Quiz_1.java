package ZB코테.week16;

import java.util.*;

public class Quiz_1 {
    public static int[] solution(int[] nums, int k) {
        int[] answer = new int[k];

        // 배열 -> set
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = (int) map.get(num);
                map.put(num, count + 1);
            } else {
                map.put(num, 1);
            }
        }

//        System.out.println("map : " + map);

        for (int i = 0; i < k; i++) {
            // 최대 value값이 중복일 때 모든 key 값을 조회해서 set에 넣기
            int maxValue = Collections.max(map.values());
            HashSet<Integer> set = new HashSet<>();
            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                if (m.getValue() == maxValue) {
                    set.add(m.getKey());
                }
            }
//            System.out.println("max : " + Collections.min(set));
            map.remove(Collections.min(set));
            answer[i] = Collections.min(set);
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int k = 3;
        System.out.println(Arrays.toString(solution(nums, k)));
    }
}


