class Solution{
    static int maxLength;
    static int maxSum;
    public int sumOfLongRootToLeafPath(Node root)
    {
       return solveSumofLongRoot(root);
    }
    
    public static int solveSumofLongRoot(Node root){
        if(root == null){
            return 0;
        }
        
        int length = 0;
        int sum = 0;
        maxLength = 0;
        maxSum = Integer.MIN_VALUE;
        
        solve(root, length, sum);
        return maxSum;
    }
    public static void solve(Node root, int length, int sum){
        if(root == null){
            if(length > maxLength){
                maxLength = length;
                maxSum = sum;
            }else if(maxLength == length){
                maxSum = sum;
            }
            return;
        }
        
        sum = sum + root.data;
        solve(root.left, length + 1, sum);
        solve(root.right, length+1, sum);
    }
}
