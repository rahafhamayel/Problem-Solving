import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]);
            while (stack.peek() != -1 && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
