
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class treeBasics {
	
	// creating tree node
	public static BinaryTreeNode<Integer> takeInputIterative() {		// taking input level wise (iteratively)
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter root of tree: ");
		
		int rootData = s.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(rootData);
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new ArrayDeque<>();
		pendingNodes.offer(rootNode);
		
		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingNodes.poll();
			
			System.out.println("Enter left child of " + front.data);
			int leftData = s.nextInt();
			if(leftData != -1) {
				BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>(leftData);
				front.left = leftNode;
				pendingNodes.offer(leftNode);
			}
			
			System.out.println("Enter right child of " + front.data);
			int rightData = s.nextInt();
			if(rightData != -1) {
				BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<Integer>(rightData);
				front.right = rightNode;
				pendingNodes.offer(rightNode);
			}
		}
		return rootNode;
	}
	
	public static BinaryTreeNode<Integer> takeInputRecursive(Scanner s){	// taking input recursively
		System.out.println("Enter data: ");
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(rootData);
		
		rootNode.left = takeInputRecursive(s);
		rootNode.right = takeInputRecursive(s);
		
		return rootNode;
	}
	
	// tree traversals - DFS and BFS
	public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static void levelOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new ArrayDeque<BinaryTreeNode<Integer>>();
		pendingNodes.offer(root);
		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingNodes.poll();
			System.out.print(front.data + " ");
			
			if(front.left != null) {
				pendingNodes.offer(front.left);
			}
			if(front.right != null) {
				pendingNodes.offer(front.right);
			}
		}
	}
	
	public static void main(String[] args) {

		BinaryTreeNode<Integer> root = takeInputIterative();
		System.out.print("Preorder traversal: ");
		preOrder(root);							// 1 2 4 8 9 5 3 6 7 
		System.out.println();
		System.out.print("Inorder traversal: ");
		inOrder(root);							// 8 4 9 2 5 1 6 3 7 
		System.out.println();
		System.out.print("Postorder traversal: ");
		postOrder(root);							//  8 9 4 5 2 6 7 3 1
		System.out.println();
		System.out.print("Level wise traversal: ");
		levelOrder(root);
	}
	
	/* 
	 					1
	 			   2    	  3
	 	       4     5     6	 7
	        8    9   	 
	*/
}