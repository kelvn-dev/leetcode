package problems.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    public static int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (head < tail) {
            int area = Math.min(height[head], height[tail]) * (tail - head);
            maxArea = Math.max(maxArea, area);
            if (height[head] <= height[tail]) {
                ++head;
            } else {
                --tail;
            }
        }
        return maxArea;
    }
}
