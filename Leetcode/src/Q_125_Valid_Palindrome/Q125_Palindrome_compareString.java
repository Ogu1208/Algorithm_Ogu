package Q_125_Valid_Palindrome;

/**
 * 문자열을 직접 비교
 * 1. `replaceAll("[^a-zA-Z0-9]", "")`를 사용해 영숫자만 남기고 나머지 문자를 제거한다.
 * 2. `toLowerCase()`를 사용해 소문자로 변경한다.
 * 3. `StringBuilder`의 `reverse()` 메서드를 사용해 뒤집은 문자열을 생성한다.
 * 4. `equals()`를 사용해 두 문자열을 비교한다.
 *
 * -> 클래스를 직접 비교, 정규식 사용 -> 속도 저하
 */
public class Q125_Palindrome_compareString {
    public boolean isPalindrome(String s) {
        // 정규식으로 유효한 문자만 추출한 다음 모두 소문자로 변경
        String s_filtered = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // 문자열을 뒤집은 다음 String으로 변경
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();
        // 두 문자열이 동일한지 비교한다.
        return s.equals(s_reversed);
    }
}
