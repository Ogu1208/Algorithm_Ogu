class Solution {
    public String solution(String s) {
        String answer = "";
        int size = s.length();
        if (size % 2 == 1) {
            answer = "" + s.charAt(size / 2);
        } else {
            answer = s.substring(size / 2 - 1, size / 2 + 1);
        }
        return answer;
    }
}