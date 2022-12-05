class Solution {
    boolean isHeap(Node root) {
       int index = 0;
       int noofNodes = count(root);
       
       if(isCBT(root, index, noofNodes) && isMaxOrder(root)){
           return true;
       }
       return false;
    }
    
    public int count(Node root){
        if(root == null){
            return 0;
        }
        
        return 1 + count(root.left) + count(root.right);
    }
    
    public boolean isCBT(Node root, int i, int noofNodes){
        if(root == null){
            return true;
        }
        
        if(i >= noofNodes){
            return false;
        }else{
            boolean left = isCBT(root.left , 2*i + 1, noofNodes);
            boolean right = isCBT(root.right, 2*i+2, noofNodes);
            return (left && right);
        }
        
    }
    
    public boolean isMaxOrder(Node root){
        // leaf node case;
        if(root.left == null && root.right == null){
            return true;
        }
        // 
        if(root.right == null){
            return (root.data > root.left.data);
        }
        else{
            return (root.data > root.left.data) && (root.data > root.right.data) && isMaxOrder(root.left) && isMaxOrder(root.right);
        }
        
    }
}
