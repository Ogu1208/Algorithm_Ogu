class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for (int n: arr) {
            answer += n;
        }
        answer /= arr.length;
        return answer;
    }
}