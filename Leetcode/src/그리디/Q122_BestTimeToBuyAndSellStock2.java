package 그리디;

public class Q122_BestTimeToBuyAndSellStock2 {

/*    static int maxProfit(int[] prices) {
        int result = 0;
        int low = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) { // 주식이 오르는 중이면
                if(i == prices.length - 1) {
                    result += prices[i] - prices[low];
                }
                continue;
            } else { // 주식이 떨어지면
                result += prices[i-1] - prices[low];
                low = i;
            }
        }

        return result;
    }*/

    static int maxProfit(int[] prices) {
        int result = 0;

        // 전체를 순회하며 다음번 값이 오르는 경우를 찾는다.
        for (int i = 0; i < prices.length - 1; i++) {
            // 다음번 값이 오르는 경우 항상 이익을 취한다.
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(prices);
        System.out.println(result);
    }
}
