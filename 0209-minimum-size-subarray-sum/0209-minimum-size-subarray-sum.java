class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;

        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            // Expand window
            sum += nums[right];

            // Shrink window while sum is valid
            while (sum >= target) {

                // Update minimum length
                minLength = Math.min(minLength, right - left + 1);

                // Remove left element
                sum -= nums[left];

                // Move left pointer
                left++;
            }
        }

        // If no valid subarray found
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}