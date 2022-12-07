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
    int n = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeHelper(root, low, high);
        return n;
    }
    public void rangeHelper(TreeNode root, int low , int high){
        if(root == null){
            return ;
        }

        if(root.val >= low && root.val <= high){
            n += root.val;
            rangeHelper(root.left, low, root.val);
            rangeHelper(root.right, root.val, high);
        }

        if(root.val < low){
            rangeHelper(root.right, low, high);
        }else if(root.val > high){
            rangeHelper(root.left, low, high);
        }
    }

}
