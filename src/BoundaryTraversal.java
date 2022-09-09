class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> list = new ArrayList<>();
	    Node root = node;
	    
	    if(root == null){
	        return list;
	    }
	    
	    list.add(root.data);
	    // traverse left part of the tree
	    traversLeft(root.left, list);
	    // traverse leaf nodes of the tree
	    tarverseLeaf(root.left,list);
	    tarverseLeaf(root.right, list);
	    
	    // traverse right node of the tree
	    traversRight(root.right, list);
	    
	    return list;
	}
	
	public static void traversLeft(Node root, ArrayList<Integer>list){
	    if((root == null) || (root.left == null && root.right == null)){
	        return;
	    }
	    
	    list.add(root.data);
	    
	    if(root.left != null){
	        traversLeft(root.left,list);
	    }else{
	        traversLeft(root.right,list);
	    }
	}
	
	public static void tarverseLeaf(Node root, ArrayList<Integer> list){
	    if(root == null){
	        return;
	    }
	    
	    if(root.left == null && root.right == null){
	        list.add(root.data);
	    }
	    
	    tarverseLeaf(root.left,list);
	    tarverseLeaf(root.right,list);
	}
	
	public static void traversRight(Node root, ArrayList<Integer>list){
	    if((root == null) || (root.left == null && root.right == null)){
	        return;
	    }
	    
	    if(root.right != null){
	        traversRight(root.right, list);
	    }else{
	        traversRight(root.left, list);
	    }
	    list.add(root.data);
	}
}
