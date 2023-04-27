package ZB코테.CT_7차코테;
import java.util.*;

public class Quiz_1 {
    public static StringBuilder sb = new StringBuilder();

    public String solution(int[][] img) {
        String answer = "";
        QuadTree(img, 0, 0, img.length);
        answer = sb.toString();
        return answer;
    }

    public static void QuadTree(int[][] img, int x, int y, int size) {

        // 압축이 가능할 경우 하나의 색상으로 압축해준다.
        if(isPossible(img, x, y, size)) {
            sb.append(img[x][y]);
            return;
        }

        int newSize = size / 2;	// 압축이 불가능 할 경우 사이즈를 절반으로 나누어야 한다.

        sb.append('(');	// 각 레벨(depth)에서 여는괄호로 시작해야한다.

        QuadTree(img, x, y, newSize);						// 왼쪽 위
        QuadTree(img, x, y + newSize, newSize);				// 오른쪽 위
        QuadTree(img, x + newSize, y, newSize);				// 왼쪽 아래
        QuadTree(img, x + newSize, y + newSize, newSize);	// 오른쪽 아래

        sb.append(')');	// 해당 레벨이 끝나면 닫는괄호도 닫아준다.


    }


    // 압축이 가능한지 해당 공간을 체크해주는 함수
    public static boolean isPossible(int[][] img, int x, int y, int size) {
        int value = img[x][y];

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(value != img[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
