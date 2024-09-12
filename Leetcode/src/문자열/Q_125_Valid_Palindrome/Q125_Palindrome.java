package 문자열.Q_125_Valid_Palindrome;

public class Q125_Palindrome {

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        // 서로 중앙으로 이동해 나가다 겹치는 지점에 도달하면 종료
        while (start < end) {
            // 영숫자인지 판별, 유효하지 않으면 한칸씩 이동
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                // 둘 다 영숫자인 경우 앞글자, 뒷글자 -> 소문자로 변경해 비교
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    // 하나라도 일치하지 않는다면 팰린드롬이 아니므로 false 리턴
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(isPalindrome);
    }
}
