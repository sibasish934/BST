class Solution {
    List<Integer> l = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);

        int start = 0;
        int end = l.size() - 1;

        while(start < end){
            int sum = l.get(start) + l.get(end);

            if(sum == k){
                return true;
            }else if(sum > k){
                end --;
            }else{
                start++;
            }
        }
        return false;
    }

    public void  inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
    }
}
