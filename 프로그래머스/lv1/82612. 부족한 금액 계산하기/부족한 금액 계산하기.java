class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        int cnt = 1;
        for (int i = 0; i < count; i++, cnt++) {
            answer += price * (i + 1);
        }
        if (money > answer) {
                    return 0;
                }
        return answer - money;
    }
}