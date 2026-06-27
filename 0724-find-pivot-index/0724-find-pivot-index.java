class Solution {
    public int pivotIndex(int[] nums) {

        int total = 0;

        for (int num : nums)
            total += num;

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            total -= nums[i];   // right sum

            if (leftSum == total){
                return i;
        }else{
            leftSum += nums[i];
        }
    }
        return -1;
    }
}