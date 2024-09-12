package 문자열.Q_125_Valid_Palindrome

class Q125_Palindrome_kotlin {
    fun isPalindrome(s: String): Boolean {
       var start = 0;
        var end = s.length -1;

        while(start < end) {
            when {
                // 영숫자인지 판별하고 유효하지 않으면 뒤로 한 칸 이동
                !Character.isLetterOrDigit(s[start]) -> start++
                !Character.isLetterOrDigit(s[end]) -> end--
                else -> {
                    // 이 외에는 유요한 문자이므로 앞 뒤 글자를 모두 소문자로 변경해 비교
                    if(Character.toLowerCase(s[start]) != Character.toLowerCase(s[end])) {
                        return false;
                    }
                    start++;
                    end--;
                }
            }
        }

        return true;

    }
}

// 파일 최상위에 main 함수 선언
fun main() {
    val palindromeChecker = Q125_Palindrome_kotlin()
    val result = palindromeChecker.isPalindrome("Do geese see God?")
    println(result) // true 출력 예상
}