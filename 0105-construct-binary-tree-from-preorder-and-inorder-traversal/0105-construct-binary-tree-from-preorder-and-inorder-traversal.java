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
            HashMap<Integer , Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
        map.put(inorder[i] , i);

    return helper(preorder , 0 ,preorder.length-1,
    inorder , 0 ,inorder.length-1);
    }
    public TreeNode helper( int[] preorder,
        int preStart,
        int preEnd,
        int[] inorder,
        int inStart,
        int inEnd ){

    if(preStart > preEnd || inStart > inEnd){
        return null;
    }
    int rootValue = preorder[preStart];
    TreeNode root = new TreeNode(rootValue);

    int mid = map.get(rootValue);
    int leftSize = mid - inStart;
     
     root.left = helper(preorder,preStart+1,preStart+leftSize,inorder ,inStart,mid-1);

     root.right = helper(preorder,preStart+leftSize + 1,preEnd,inorder,mid+1,inEnd);
    
     return root;

    }
}