class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        if(root == null){
            return l;
        }
        boolean leftToRight = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i= 0; i < size; i++){
                TreeNode temp = q.poll();
                if(leftToRight){
                    list.add(0,temp.val);
                }else{
                      list.add(temp.val);
                }
                if(temp.left != null){
                    q.offer(temp.left);
                }
                
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
            l.add(list);
            leftToRight = !leftToRight;
        }
        return l;
    }
}
