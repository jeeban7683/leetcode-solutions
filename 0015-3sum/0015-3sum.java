class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // Create answer list
        List<List<Integer>> ans = new ArrayList<>();

        // If size less than 3
        if (nums.length < 3) {
            return ans;
        }

        // Sort array
        Arrays.sort(nums);

        // Use set to avoid duplicate triplets
        Set<List<Integer>> set = new HashSet<>();

        // Fix one element
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            // Two pointer
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // Triplet found
                if (sum == 0) {

                    set.add(Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]
                    ));

                    left++;
                    right--;
                }

                // Need bigger sum
                else if (sum < 0) {
                    left++;
                }

                // Need smaller sum
                else {
                    right--;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
