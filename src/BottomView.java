class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
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
            map.put(index,temp.data);
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
