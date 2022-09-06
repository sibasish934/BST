class Solution {
    public int minDepth(TreeNode root) {
        int ans = 0;
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }else if(root.left == null){
            return 1 + minDepth(root.right);
        }else if(root.right == null){
            return 1 + minDepth(root.left);
        }else{
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            
            ans = Math.min(left,right)+1;
        } 
        
        return ans;
    }
}
