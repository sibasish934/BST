class Solution {
    List<List<Integer>> l = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>(), targetSum, 0);
        return l;
    }

    public void dfs(TreeNode root, List<Integer>sum , int targetSum , int currSum){
        if(root == null){
            return;
        }

        int target = root.val + currSum;
        sum.add(root.val);

        if(root.left == null && root.right == null){
            if(target == targetSum){
                l.add(sum);
            }else{
                return ;
            }
        }

        if(root.left != null){
            dfs(root.left, new ArrayList<>(sum), targetSum, target);
        }

        if(root.right != null){
            dfs(root.right, new ArrayList<>(sum), targetSum, target);
        }
    }
}
