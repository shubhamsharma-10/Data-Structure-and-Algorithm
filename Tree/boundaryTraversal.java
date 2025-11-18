import java.util.ArrayList;

public class boundaryTraversal {
    
   public static void boundaryOrderTraversal(BinaryTreeNode<Integer> root, ArrayList<Integer> ans) {
    	if(root == null) {
    		return;
    	}
    	ans.add(root.data);
    	leftSubtree(root.left, ans);
    	leafNode(root, ans);
    	rightSubtree(root.right, ans);
    }
    
    private static void leftSubtree(BinaryTreeNode<Integer> root, ArrayList<Integer> ans) {
    	if(root == null || (root.left == null && root.right == null)) {
    		return;
    	}
    	ans.add(root.data);
    	leftSubtree(root.left, ans);
    	if(root.left == null) {
    		leftSubtree(root.right, ans);
    	}
    }
    
    private static void leafNode(BinaryTreeNode<Integer> root, ArrayList<Integer> ans) {
    	if(root == null) {
    		return;
    	}
    	if(root.left == null &&  root.right == null) {
    		ans.add(root.data);
    		return;
    	}
    	leafNode(root.left, ans);
    	leafNode(root.right, ans);
    }
    
    private static void rightSubtree(BinaryTreeNode<Integer> root, ArrayList<Integer> ans) {
    	if(root == null || (root.left == null && root.right == null)) {
    		return;
    	}
    	ans.add(root.data);
    	rightSubtree(root.right, ans);
    	if(root.right == null) {
    		rightSubtree(root.left, ans);
    	}
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);
        root.left.right.left = new BinaryTreeNode<>(8);
        root.left.right.right = new BinaryTreeNode<>(9);
        
        ArrayList<Integer> ans = new ArrayList<>();
        boundaryOrderTraversal(root, ans);
        System.out.println(ans);
    }
}