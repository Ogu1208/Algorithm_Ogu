class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] iArr = new int[10];

        for (int n : numbers) {
            iArr[n]++;
        }
        
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == 0)
                answer += i;
        }
        return answer;
    }
}