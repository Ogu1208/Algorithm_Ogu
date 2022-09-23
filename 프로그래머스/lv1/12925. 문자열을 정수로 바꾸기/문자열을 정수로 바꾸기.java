class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean isMinus = false;
        if(s.charAt(0) == '+') {
            s = s.substring(1);
        } else if (s.charAt(0) == '-') {
            s = s.substring(1);
            isMinus = true;
        }
        
        answer = Integer.parseInt(s);
        answer = isMinus? answer * -1 : answer;
        
        return answer;
    }
}