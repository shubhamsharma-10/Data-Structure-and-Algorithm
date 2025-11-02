import java.util.ArrayDeque;
import java.util.Queue;

public class opsOnTree {
	
	public static BinaryTreeNode<Integer> tree(int[] list){
		if(list.length == 0 || list[0] == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(list[0]);
		Queue<BinaryTreeNode<Integer>> pendingNodes = new ArrayDeque<>();
		pendingNodes.offer(rootNode);
		
		int i = 1;
		while(!pendingNodes.isEmpty() && i < list.length) {
			BinaryTreeNode<Integer> front  = pendingNodes.poll();
			
			if(list[i] != -1) {
				front.left = new BinaryTreeNode<Integer>(list[i]);
				pendingNodes.offer(front.left);
			}
			i++;
			if(i >= list.length) break;
			
			if(list[i] != -1) {
				front.right = new BinaryTreeNode<Integer>(list[i]);
				pendingNodes.offer(front.right);
			}
			i++;
		}
		return rootNode;
	}
	
	public static void print(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		print(root.left);
		print(root.right);
	}
	
	public static int sizeOfTree(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		
		int leftCount = sizeOfTree(root.left);
		int rightCount = sizeOfTree(root.right);
		int ans = 1 + leftCount + rightCount;
		return ans;
	}
	
	public static int sumOfTree(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		
		int sum = root.data + sumOfTree(root.left) + sumOfTree(root.right);
		return sum;
	}
	
	public static int leafNode(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		return leafNode(root.left) + leafNode(root.right);
	}
	
	public static int nonLeafNode(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		
		if(root.left != null || root.right != null) {
			return 1 + nonLeafNode(root.left) + nonLeafNode(root.right);
		}else {
			return 0;
		}
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}

	public static void main(String[] args) {
		int[] list = {1, 2, 3, 4, 5, 6, 7, 8, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		BinaryTreeNode<Integer> root = tree(list);
		print(root);
		System.out.println();
		int ans = sizeOfTree(root);
		System.out.println("Total number of nodes: " + ans);
		int sum = sumOfTree(root);
		System.out.println("Total sum od nodes: " + sum);
		int leafNod = leafNode(root);
		System.out.println("Total leaf nodes: " + leafNod);
		int nonLeafNode = nonLeafNode(root);
		System.out.println("Non leaf nodes: " + nonLeafNode);
		int height = height(root);
		System.out.println("Height of tree: " + height);

	}
}
