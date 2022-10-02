class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = Math.max(n, m);
        int min = Math.min(n, m);

        // 최대 공약수 (유클리드 호제법)
        while(min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }

        // 최대 공배수 - 두수의 곱 / 최대공약수
        int gcd = n * m / max;
        answer = new int[]{max, gcd};
        return answer;
    }
}