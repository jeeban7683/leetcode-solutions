class Solution {

    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {

        int st = 0;
        int end = nums.length - 1;

        int ans = -1;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {

                ans = mid;

                // Target found, but search further left
                end = mid - 1;

            } 
            else if (nums[mid] < target) {

                st = mid + 1;

            } 
            else {

                end = mid - 1;
            }
        }

        return ans;
    }

    private int findLast(int[] nums, int target) {

        int st = 0;
        int end = nums.length - 1;

        int ans = -1;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {

                ans = mid;

                // Target found, but search further right
                st = mid + 1;

            } 
            else if (nums[mid] < target) {

                st = mid + 1;

            } 
            else {

                end = mid - 1;
            }
        }

        return ans;
    }
}