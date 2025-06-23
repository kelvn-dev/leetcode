package problems.arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int nums[] = new int[] {1, 1, 2};
    }

    public int removeDuplicates(int[] nums) {
        int firstIndexOfLastElement = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != nums[firstIndexOfLastElement]) {
                ++firstIndexOfLastElement;
                nums[firstIndexOfLastElement] = nums[i];
            }
        }
        return firstIndexOfLastElement + 1;
    }
}
