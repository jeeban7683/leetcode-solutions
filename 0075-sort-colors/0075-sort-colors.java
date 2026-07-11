class Solution {
    public void sortColors(int[] nums) {
        int st = 0;                  // Position to place 0
        int mid = 0;                 // Current index
        int end = nums.length - 1;   // Position to place 2

        while (mid <= end) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, st, mid);
                    st++;
                    mid++;          // Move mid forward
                    break;

                case 1:
                    mid++;          // 1 is already in correct position
                    break;

                case 2:
                    swap(nums, mid, end);
                    end--;          // Do not increment mid here
                    break;
            }
        }
    }

    public void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}