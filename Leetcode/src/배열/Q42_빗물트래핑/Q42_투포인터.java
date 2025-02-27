package 배열.Q42_빗물트래핑;

/**
 * 풀이 방법 : 투 포인터를 최대로 이동
 * 난이도 : hard
 * 시간 복잡도 : O(n)
 * 1. left, right 포인터를 이용하여 최대 높이를 갱신하면서 이동
 * 2. leftMax, rightMax를 이용하여 최대 높이를 갱신하면서 이동
 * 3. leftMax <= rightMax인 경우 left 포인터를 이동하고, 반대인 경우 right 포인터를 이동
 *
 * 	1.	물의 양은 좌우 최대 높이에 의해 결정됨:
 * 물이 담기는 높이는 현재 위치의 높이가 아니라 그 위치 기준으로 왼쪽과 오른쪽의 최대 높이에 따라 결정됩니다. 예를 들어, 어떤 위치에서 물이 얼마나 쌓일지 계산하려면 해당 위치의 높이와 그 위치의 왼쪽/오른쪽 최대 높이의 차이를 알아야 합니다.
 * 	2.	좌우에서 이동하면서 비교:
 * 만약 왼쪽의 최대 높이가 오른쪽의 최대 높이보다 낮거나 같다면, 왼쪽에서부터 오른쪽으로 이동하면서 왼쪽 최대 높이를 갱신하고 해당 위치의 물을 계산할 수 있습니다. 반대의 경우도 동일하게 오른쪽에서 왼쪽으로 이동하며 오른쪽 최대 높이를 갱신하고 물의 양을 계산할 수 있습니다.
 * 	3.	투포인터로 중앙으로 수렴:
 * 투포인터를 사용하여 양 끝에서 시작해 중앙으로 이동하면서 필요한 값을 계산할 수 있습니다. left와 right 포인터가 서로 만나기 전까지 반복하면서 매 순간 leftMax와 rightMax를 갱신하고 현재 높이와의 차이를 통해 물의 양을 계산하는 방식입니다.
 */
public class Q42_투포인터 {
//    public static int trap(int[] height) {
//        int volume = 0;
//        int left = 0;
//        int right = height.length - 1;
//        int leftMax = height[left];
//        int rightMax = height[right];
//
//        while (left < right) {
//            leftMax = Math.max(leftMax, height[left]);
//            rightMax = Math.max(rightMax, height[right]);
//
//            if (leftMax <= rightMax) {
//                volume += leftMax - height[left];
//                left += 1;
//            } else {
//                volume += rightMax - height[right];
//                right -= 1;
//            }
//        }
//
//        return volume;
//    }

    public static int trap(int[] height) {
        int volume = 0;
        int left = 0;
        int right = height.length - 1;  // 11
        int leftMax = height[left];  // 0
        int rightMax = height[right];  // 1
        int n = 0;

        while (left < right) {
            System.out.println("--------------------");
            System.out.println("n: " + n);
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax <= rightMax) {
                if (leftMax > height[left]) {
                    volume += leftMax - height[left];
                }
                left++;
                System.out.println("leftMax: " + leftMax + ", rightMax: " + rightMax + ", volume: " + volume + ", left: " + (left-1) + ", right: " + (right));
            } else {
                System.out.println("right:" + right + ", rightMax: " + rightMax + ", height[right]: " + height[right]);
                if (rightMax > height[right]) {
                    volume += rightMax - height[right];
                }
                right--;
                System.out.println("leftMax: " + leftMax + ", rightMax: " + rightMax + ", volume: " + volume + ", left: " + (left) + ", right: " + (right+1));
            }
            n++;
        }
        return volume;

    }


    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(trap(height));

        height = new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6};
        System.out.println(trap(height));
    }
}
