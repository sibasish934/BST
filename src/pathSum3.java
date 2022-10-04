class Solution {
    int count = 0;
    List<Integer> l = new ArrayList<>();
    public int pathSum(TreeNode root, int targetSum) {
        getSum(root, targetSum);
        return count;
    }

    public void getSum(TreeNode root, int targetSum){
        if(root == null){
            return;
        }

        l.add(root.val);

        getSum(root.left, targetSum);

        getSum(root.right, targetSum);

        int temp = 0;

        for(int i = l.size()-1; i>= 0; i--){
            temp+= l.get(i);

            if(temp == targetSum){
                count++;
            }
        }

        l.remove(l.size() -1);
    }
}
