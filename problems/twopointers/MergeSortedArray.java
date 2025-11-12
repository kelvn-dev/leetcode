package problems.twopointers;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        int m = 3;
        int n = 3;
        // [1,2,2,3,5,6]
        merge(nums1, m, nums2, n);
        for (int i: nums1) {
            System.out.print(i + " ");
        }
    }

    /**
     * move backwards from the end of the arrays
     * 1. Use index1 and index2 starting from the end of nums1 and nums2, and index from the very end of nums1
     * 2. Compare and place the larger one at the index position
     * 3. If any elements are left in nums2, copy them to nums1
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums2[index2] > nums1[index1]) {
                nums1[index] = nums2[index2];
                --index2;
            } else {
                nums1[index] = nums1[index1];
                --index1;
            }
            --index;
        }

        while (index2 >= 0) {
            nums1[index] = nums2[index2];
            --index2;
            --index;
        }
    }
}
