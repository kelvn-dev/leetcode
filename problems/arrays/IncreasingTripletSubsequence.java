package problems.arrays;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 5, 0, 6};
        boolean result = increasingTriplet(nums);
        System.out.println(result);
    }

    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
