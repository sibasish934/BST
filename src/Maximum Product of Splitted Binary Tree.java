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
    long totalSum= 0;
    long maxProd = 0;
    public int maxProduct(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        calculateSubtreeSum(root);
        return (int)(maxProd % (int)(Math.pow(10, 9) + 7));
    }

    public void dfs(TreeNode root){
        if(root == null){
            return ;
        }
        dfs(root.left);
        dfs(root.right);
        totalSum += (long)root.val;
    }

    public long calculateSubtreeSum(TreeNode root){
        if(root == null){
            return 0;
        }
        long l = calculateSubtreeSum(root.left);
        long r = calculateSubtreeSum(root.right);
        long subtreeSum = l+r+root.val;
        maxProd = Math.max(maxProd, (subtreeSum) * (totalSum - subtreeSum));
        return subtreeSum;
    }
}
