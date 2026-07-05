/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            ans.add(String.valueOf(root.val));
            return ans;
        }

        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        for (String path : left) {
            ans.add(root.val + "->" + path);
        }

        for (String path : right) {
            ans.add(root.val + "->" + path);
        }

        return ans;
    }
}