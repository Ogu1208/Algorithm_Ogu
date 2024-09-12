package 문자열.Q_344_Reverse_String

class Q334_Revserse_String_kotlin {

    companion object {
        fun reverseString(s: CharArray): Unit {
            var start = 0
            var end = s.size - 1

            while(start < end) {
                s[start] = s[end].also { s[end] = s[start] }

                start++
                end--
            }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val s = charArrayOf('h', 'e', 'l', 'l', 'o')
            reverseString(s)
            println(s) // olleh 출력 예상
        }
    }
}