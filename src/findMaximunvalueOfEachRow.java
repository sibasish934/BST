class Solution {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode>q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for(int i = 0; i<size; i++){
                 TreeNode temp = q.poll();
                 max = Math.max(max, temp.val);
                
                if(temp.left != null){
                    q.offer(temp.left);
                }
                
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
            
            list.add(max);
        }
        
        return list;
    }
}
