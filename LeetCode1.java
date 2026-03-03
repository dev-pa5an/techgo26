import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> comp = new HashMap<>();
        int p = 0;

        while (p < nums.length) {
            if (comp.containsKey(nums[p])) {
                return new int[]{p, comp.get(nums[p])};
            } else {
                comp.put(target - nums[p], p);
                p += 1;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {

        int[] ans = twoSum(new int[]{2, 7, 5, 1}, 9);

        System.out.println(Arrays.toString(ans));
    }
}