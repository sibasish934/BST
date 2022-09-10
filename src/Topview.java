class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer>list = new ArrayList<>();
        if(root == null){
            return list;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        topviewFinder(root, map, 0);
        list.addAll(map.values());
        return list;
    }
    
    public static void topviewFinder(Node root,TreeMap<Integer, Integer> map, int idx ){
        Queue<Node>q = new LinkedList<>();
        Queue<Integer>l = new LinkedList<>();
        q.offer(root);
        l.offer(idx);
        while(!q.isEmpty()){
            Node temp = q.poll();
            int index = l.poll();
            if(!map.containsKey(index)){
                map.put(index,temp.data);
            }
            if(temp.left != null){
                q.offer(temp.left);
                l.offer(index-1);
            }
            if(temp.right != null){
                q.offer(temp.right);
                l.offer(index+1);
            }
        }
    }
}
