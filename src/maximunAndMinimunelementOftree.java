class Solution{
    public static int findMax(Node root){
        if(root == null){
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        int res = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        ans = Math.max(left, Math.max(right, res));
        return ans;
    }
    public static int findMin(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        
        int ans = Integer.MAX_VALUE;
        int res = root.data;
        int left = findMin(root.left);
        int right = findMin(root.right);
        ans = Math.min(left, Math.min(right , res));
        
        return ans;
    }
}
