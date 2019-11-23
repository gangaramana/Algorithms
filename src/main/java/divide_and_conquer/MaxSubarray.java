package divide_and_conquer;

public class MaxSubarray {
    public static void main(String[] args) {
        int[] n = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubarray max = new MaxSubarray();
        int x = max.maxSubArray(n);
        System.out.println(x);
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int start = 0, end = 0;
        int sum = 0;
        if (len > 0) {
            sum = nums[0];
            int prevSum = nums[0];
            for (int i = 1; i < len; i++) {
                if (prevSum < prevSum + nums[i]) {

                }
//
//                prevSum = Math.max(nums[i], prevSum + nums[i]);
//                sum = Math.max(sum, prevSum);
                if (sum <= prevSum) {
                    sum = prevSum;
                    end = i;
                }
            }

        }
        return sum;

    }
}
