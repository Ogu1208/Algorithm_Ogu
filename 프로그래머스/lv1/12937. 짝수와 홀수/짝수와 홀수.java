class Solution {
    public String solution(int num) {
        if (num % 2 == 0 || num == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }
}