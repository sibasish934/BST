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
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        TreeNode root = solve(preorder, inorder, 0, inorder.length -1);
        return root;
    }
    
    public TreeNode solve(int[]preorder, int[]inorder, int start, int end){
        if(start > end){
            return null;
        }
        
       int element = preorder[preIndex++];
       TreeNode root = new TreeNode(element);
        
       if(root == null){
           return null;
       }
        
      if(start == end){
          return root;
      }
       int pos = map.get(element);
       root.left = solve(preorder, inorder, start, pos-1);
       root.right = solve(preorder, inorder, pos+1,end);
        return root;
        
    }
}
