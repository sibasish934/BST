/* this is 1st and optimised solution to the given problem */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }
        
        if(root == null){
            return 0;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}

/* Second solution with little higher time complexity is */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        ArrayList<Integer> list = new ArrayList<>(); // this can also done using a count varible without adding it to the Arraylist.

        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            list.add(temp.val);
            if(temp.left != null){
                q.offer(temp.left);
            }
            if(temp.right != null){
                q.offer(temp.right);
            }
        }

        return list.size();
    }
}
