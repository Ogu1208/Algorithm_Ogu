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
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(prices);
        System.out.println(result);
    }
}
