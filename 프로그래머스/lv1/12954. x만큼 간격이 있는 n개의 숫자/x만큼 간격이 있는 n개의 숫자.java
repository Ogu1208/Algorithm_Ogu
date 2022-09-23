

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int plus = x;

        for (long i = 0; i < n; i++) {
            answer[(int)i] = (long)x * (i+1) ;
        }

        return answer;
    }
}