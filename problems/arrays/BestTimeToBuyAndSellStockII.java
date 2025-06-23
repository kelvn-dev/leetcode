package problems.arrays;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] nums = new int[]{7,6,4,3,1};
        int result = maxProfit(nums);
        System.out.println(result);
    }

    /**
     * If detect smaller price, sell on previous day and buy at today
     */
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < prices[i - 1]) {
                maxProfit += prices[i - 1] - minPrice;
                minPrice = prices[i];
            } else if (i == prices.length - 1) {
                maxProfit += prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    /**
     * In a simplified manner, the problem reduces to accumulating all positive differences between consecutive days
     */
    public static int maxProfitII(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
