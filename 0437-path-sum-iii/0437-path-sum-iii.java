class Solution {

    public int pathSum(TreeNode root, int targetSum) {

        Map<Long, Integer> prefix = new HashMap<>();

        // Empty path has prefix sum 0
        prefix.put(0L, 1);

        return dfs(root, 0, targetSum, prefix);
    }

    private int dfs(TreeNode root,
                    long currentSum,
                    int target,
                    Map<Long, Integer> prefix) {

        if (root == null) {
            return 0;
        }

        // Current prefix sum
        currentSum += root.val;

        // Count paths ending at this node
        int count = prefix.getOrDefault(currentSum - target, 0);

        // Add current prefix sum
        prefix.put(currentSum,
                   prefix.getOrDefault(currentSum, 0) + 1);

        // Traverse children
        count += dfs(root.left, currentSum, target, prefix);
        count += dfs(root.right, currentSum, target, prefix);

        // Backtrack
        prefix.put(currentSum, prefix.get(currentSum) - 1);

        return count;
    }
}