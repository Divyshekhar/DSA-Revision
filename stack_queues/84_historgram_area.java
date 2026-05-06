
import java.util.*;

class stack_queues {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int nse, pse;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!st.empty() && heights[i] < heights[st.peek()]) {
                nse = i;
                int element = st.pop();
                pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            nse = n;
            int element = st.pop();
            pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
        }
        return maxArea;
    }

    public int largestRectangleAreaSelf(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int nse, pse;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                nse = i;
                int element = st.pop();
                pse = (st.isEmpty()) ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            nse = n;
            int element = st.pop();
            pse = (st.isEmpty()) ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}
