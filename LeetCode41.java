import java.util.HashSet;
import java.util.Set;

public class LeetCode41 {
    public int firstMissingPositive(int[] nums) { //8:40
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        if (!set.contains(1)) return 1; //nums does not conatin 1
        int min = Integer.MAX_VALUE;
        for (int n : set) {
            if (n - 1 < min && !set.contains(n-1) && n - 1 > 0) {
                min = n - 1;
            } else if (n + 1 < min && !set.contains(n+1) && n + 1 > 0) {
                min = n + 1;
            }
        }
        return min;
    }
}
