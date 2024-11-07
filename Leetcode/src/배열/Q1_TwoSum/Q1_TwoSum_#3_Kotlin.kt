package 배열.Q1_TwoSum

class `Q1_TwoSum_#3_Kotlin` {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numsMap: MutableMap<Int, Int> = mutableMapOf()

        // 하나의 for 반복으로 통합
        for ((i, num) in nums.withIndex()) {
            // target에서 num을 뺀 값이 있으면 정답으로 리턴
            if (numsMap.containsKey(target - num)) {
                return intArrayOf(numsMap[target - num] ?:0, i)
            }

            // 없으면 현재 값을 키로, 인덱스를 값으로 저장
            numsMap[num] = i
        }

        return intArrayOf(0, 0)
    }
}