class Solution {
    String str = "";
    public String tree2str(TreeNode root) {
        preorder(root);
        return str;
    }
    
    public void preorder(TreeNode root){
        if(root == null){
            return ;
        }
        str += String.valueOf(root.val);
        
        if(root.left != null){
            str += "(";
            preorder(root.left);
            str += ")";
        }
        if(root.right != null){
            if(root.left == null){
                str += "()";
            }
            str += "(";
            preorder(root.right);
            str += ")";
        }
    }
}
