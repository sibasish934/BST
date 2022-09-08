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
    Map<Integer, Integer> map = new HashMap<>();
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        // System.out.println(map);
        TreeNode root = solve(inorder,postorder,0,inorder.length-1);
        return root;
    }
    public TreeNode solve(int []inorder, int[]postorder, int start, int end){
        if(start > end){
            return null;
        }
        
        int element = postorder[index--];
        // System.out.println(index);
        TreeNode root = new TreeNode(element);
        
        if(root == null){
            return null;
        }
        
        if(start == end){
            return root;
        }
        
        int pos = map.get(element);
        
        root.right = solve(inorder, postorder,pos+1, end);
        root.left = solve(inorder, postorder,start, pos-1);
        return root;
    }
}
