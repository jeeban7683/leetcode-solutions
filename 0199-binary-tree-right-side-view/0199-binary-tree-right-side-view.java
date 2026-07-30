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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
        int size = q.size();

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<size;i++){
            TreeNode curr = q.poll();

            stack.push(curr.val);

            if(curr.left!=null){
                q.offer(curr.left);
            }

            if(curr.right != null){
                q.offer(curr.right);
            }
         
        }
           ans.add(stack.peek());
        }
       return ans;
    }
}