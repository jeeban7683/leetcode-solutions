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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean reverse = false;

        while (!q.isEmpty()) {

            int size = q.size();

            List<Integer> level = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                if (reverse)
                    stack.push(curr.val);
                else
                    level.add(curr.val);

                if (curr.left != null)
                    q.offer(curr.left);

                if (curr.right != null)
                    q.offer(curr.right);
            }

            while (!stack.isEmpty()) {
                level.add(stack.pop());
            }

            ans.add(level);

            reverse = !reverse;
        }

        return ans;
    }
}
