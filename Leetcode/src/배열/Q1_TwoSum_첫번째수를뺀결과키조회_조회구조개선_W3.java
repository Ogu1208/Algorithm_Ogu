package 배열;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum_첫번째수를뺀결과키조회_조회구조개선_W3 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        // 하나의 for 반복으로 통합
        for (int i = 0; i < nums.length; i++) {
            // target에서 nums를 뺀 값이 있으면 정답으로 리턴
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            // 정답이 아니므로 다음번 비교를 위해 인덱스를 맵에 저장
            numsMap.put(nums[i], i);
        }
        // 항상 정답이 존재되므로 널이 return되는 경우는 없음
        return null;
    }
}
