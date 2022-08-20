import java.util.Stack;
public class binaryTree {
    private static treeNode root;
    public static class treeNode{
        private final int data;
        private treeNode left;
        private treeNode right;

        treeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void createBinaryTree(){
        treeNode first = new treeNode(1);
        treeNode second = new treeNode(2);
        treeNode third = new treeNode(3);
        treeNode four = new treeNode(4);
        treeNode five = new treeNode(5);

        root = first;
        root.left = second;
        root.right = third;
        second.left = four;
        second.right = five;
    }

    public void preOrder(treeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(treeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public void postOrder(treeNode root){
        if(root == null){
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    // iterative coding approach for traversing the binary tree

    public void preOrderIterative(){
        if(root == null){
            return;
        }
        Stack <treeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            treeNode temp = s.pop();
            System.out.print(temp.data+" ");
            if(temp.right != null){
                s.push(temp.right);
            }
            if(temp.left != null){
                s.push(temp.left);
            }
        }
    }
    public static void main(String[] args) {
        binaryTree bt = new binaryTree();
        bt.createBinaryTree();
        bt.preOrder(root);
        System.out.print("\n");
        bt.inOrder(root);
        System.out.print("\n");
        bt.postOrder(root);
        System.out.print("\n");
        bt.preOrderIterative();

    }

}