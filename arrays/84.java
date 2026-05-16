
import java.util.*;

class arrays {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int nse, pse;
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                nse = i;
                int element = st.pop();
                pse = (st.isEmpty()) ? -1 : st.peek();
                maxi = Math.max(maxi, (heights[element] * (nse - pse - 1)));
            }
            st.push(i);
        }
        while (!st.isEmpty()) { // for the other case where the element was not found smaller than the st.peek();
            nse = n;
            int element = st.pop();
            pse = (st.isEmpty()) ? -1 : st.peek();
            maxi = Math.max(maxi, (heights[element] * (nse - pse - 1)));
        }
        return maxi;
    }

    public static void main(String[] args) {

    }
}
