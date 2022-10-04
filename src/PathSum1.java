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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> value = new LinkedList<>();

        q.add(root);
        value.add(root.val);

        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            int sumvalue = value.poll();

            if(temp.left == null && temp.right == null && targetSum == sumvalue){
                return true;
            }

            if(temp.left != null){
                q.add(temp.left);
                value.add(temp.left.val + sumvalue);
            }

            if(temp.right != null){
                q.add(temp.right);
                value.add(temp.right.val + sumvalue);
            }
        }

        return false;
    }
}
