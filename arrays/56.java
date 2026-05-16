
import java.util.*;

class arrays {

    public int[][] merger(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] it : intervals) {
            if (!ans.isEmpty() && ans.get(ans.size() - 1)[1] >= it[0]) {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], it[1]);
            }
            else{
                ans.add(it);
            }
        }
        return ans.toArray(int[][]::new);
    }

    public static void main(String[] args) {

    }
}
