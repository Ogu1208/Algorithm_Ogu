package ZB코테.week12;

public class Quiz_1 {
    public static int solution(String s) {
        int answer = 0;
        String str = "";
        char[] cArray = s.toCharArray();

        while (!str.equals("a")) {

            // 중복된 문자 제거
            char prev = 0;
            int k = 0;
            int idx = 0;

            for (char c: cArray)
            {
                if (prev != c)
                {
                    cArray[k++] = c;
                    prev = c;
                }
            }

            str = new String(cArray).substring(0, k);
            cArray = str.toCharArray();
            System.out.println("remove Duplicated: " + str);
//             'a'문자가 단독으로 나타날 경우, 왼쪽 문자와 오른쪽 문자를 'a'로 변경
            for (int i = 0; i < cArray.length; i++) {
                if (cArray[i] == 'a')
                {
                    if (i == 0) {
                        cArray[i+1] = 'a';
                        i++;
                    } else if (i == cArray.length - 1) {
                        cArray[i-1] = 'a';
                        break;
                    } else {
                        cArray[i-1] = 'a';
                        cArray[i+1] = 'a';
                        i++;
                    }
                }
            }

            str = new String(cArray);

            System.out.println("단독'a': " + str);
        }


        System.out.println("answer: " + answer);
        return answer;
    }

    public static void main(String[] args) {
       solution("azbacefbaaaa");
    }
}
