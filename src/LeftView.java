class Solution
{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node)
    {
       Node root = node;
       ArrayList<Integer>list = new ArrayList<>();
       solve(root, list);
       return list;
    }
    public static void solve(Node root, ArrayList<Integer>list){
        if(root == null){
            return ;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node temp = q.poll();
                if(i == 0){
                    list.add(temp.data);
                }
                
                if(temp.left!= null){
                    q.offer(temp.left);
                }
                
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
        }
    }
}

