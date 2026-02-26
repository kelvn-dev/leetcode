package problems.arrays;

/**
 * keeping track of the minimum price encountered so far and calculate benefit at each iteration
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int result = maxProfit(nums);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i: prices) {
            if (i < minPrice) {
                minPrice = i;
            }

            maxProfit = Math.max(maxProfit, i - minPrice);
        }

        return maxProfit;
    }
}
