import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = Long.toString(n);
        int[] iArray = new int[s.length()];
        
        for (int i = 0; i < iArray.length; i++) {
            iArray[i] = s.charAt(i) - '0';
        }
        
        Arrays.sort(iArray);
        s = "";
        
        for (int i = iArray.length - 1; i >= 0; i--) {
            s += iArray[i] + "";
        }
        
        answer = Long.valueOf(s).longValue();
        return answer;
    }
}