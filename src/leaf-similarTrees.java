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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        findLeafNodes(root1, arr1);
        findLeafNodes(root2, arr2);

        if(arr1.size() == arr2.size()){
            for(int i = 0; i <arr1.size(); i++){
                if(arr1.get(i) != arr2.get(i)){
                    return false;
                }
            }
        }else{
            return false;
        }

        return true;
    }

    public void findLeafNodes(TreeNode root, ArrayList <Integer> arr){
         if(root.left == null && root.right == null){
             arr.add(root.val);
         }

         if(root.left != null){
             findLeafNodes(root.left, arr);
         }

         if(root.right != null){
             findLeafNodes(root.right, arr);
         }
    }
}
