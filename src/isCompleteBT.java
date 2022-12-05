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
    public boolean isCompleteTree(TreeNode root) {
        int index = 0;
        int noofNodes = count(root);
        if(isCBT(root, index, noofNodes)){
            return true;
        }
        return false;
    }

    public int count(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }

    public boolean isCBT(TreeNode root, int i, int noofNodes){
        if(root == null){
            return true;
        }

        if(i >= noofNodes){
            return false;
        }else{
            boolean left = isCBT(root.left, 2*i+1, noofNodes);
            boolean right = isCBT(root.right, 2*i+2, noofNodes);
            return (left && right);
        }
    }
}
