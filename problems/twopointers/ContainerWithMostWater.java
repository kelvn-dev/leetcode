package problems.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    /**
     * 1. Calculate area by min(height) * width
     * 2. Move the pointer of shorter line (because increase smaller height is the only way to increase area)
     */
    public static int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (head < tail) {
            // step 1
            int area = Math.min(height[head], height[tail]) * (tail - head);
            maxArea = Math.max(maxArea, area);

            // step 2
            if (height[head] <= height[tail]) {
                ++head;
            } else {
                --tail;
            }
        }
        return maxArea;
    }
}
