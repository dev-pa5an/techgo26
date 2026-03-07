public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int[] fSum = new int[nums.length];
        int[] rSum = new int[nums.length];

        fSum[0] = 1;
        rSum[nums.length-1] = 1;

        for (int i = 1; i < nums.length; i++) {
            fSum[i] = fSum[i-1] * nums[i-1];
            rSum[nums.length-1-i] = rSum[nums.length-i] * nums[nums.length - i];
        }
        int[] ans = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            ans[j] = fSum[j] * rSum[j];
        }
        return ans;
    }
}
