class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int n = 0;
        int tmp = x;
        while (tmp > 0) {
            n += tmp % 10;
            tmp /= 10;
        }
        
        if(x % n == 0)
            answer = true;
        else
            answer =  false;
        
        return answer;
    }
}