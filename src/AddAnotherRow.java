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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
         if(root == null){
            return new TreeNode(val);
        }

        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> q = new LinkedList<>(); 
        q.offer(root);

        while(--depth > 1){
            int size = q.size();
            for(int i = 0; i<size;i++){
                TreeNode temp = q.poll();
                if(temp.left != null){
                    q.offer(temp.left);
                }

                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
            
        }

        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            TreeNode lst = temp.left;
            TreeNode rst = temp.right;

            temp.left = new TreeNode(val);
            temp.right = new TreeNode(val);

            temp.left.left = lst;
            temp.right.right = rst;

        }


        return root;
    }
}
