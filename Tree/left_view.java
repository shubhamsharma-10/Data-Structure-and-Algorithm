import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class left_view {
    public static ArrayList<Integer> leftView(BinaryTreeNode<Integer> root){
		ArrayList<Integer> ans = new ArrayList<>();
		if(root == null) {
			return ans;
		}
		Queue<BinaryTreeNode<Integer>> pendingNode = new ArrayDeque<>();
		pendingNode.offer(root);
		while(!pendingNode.isEmpty()) {
			int n = pendingNode.size();
			while(n != 0) {
				BinaryTreeNode<Integer> front = pendingNode.poll();
				if(n == 1) {
					ans.add(front.data);
				}
				if(front.right != null) {
					pendingNode.offer(front.right);
				}
				if(front.left != null) {
					pendingNode.offer(front.left);
				}
				n--;
			}
		}
		return ans;
	}

	// Recursive Approach 
	public static void leftViewRecursion(BinaryTreeNode<Integer> root, ArrayList<Integer> ans, int lvl){		// M1 - using lvl == ans.size() 
		if(root == null) {
			return;
		}
		if(lvl == ans.size()) {
			ans.add(root.data);
		}
		leftViewRecursion(root.left, ans, lvl+1);
		leftViewRecursion(root.right, ans, lvl+1);
	}
	
	private static int maxLevel = -1;
	public static void leftViewRecursion2(BinaryTreeNode<Integer> root, ArrayList<Integer> ans, int lvl){ 		// M2 - using static variable
		if(root == null) {
			return;
		}
		if(lvl > maxLevel) {
			ans.add(root.data);
			maxLevel = lvl;
		}
		leftViewRecursion2(root.left, ans, lvl+1);
		leftViewRecursion2(root.right, ans, lvl+1);
	}

	public static int leftViewRecursion3(BinaryTreeNode<Integer> root, ArrayList<Integer> ans, int maxLevel, int lvl){ 	// M3 - passing maxLevel as parameter and returning it
		if(root == null) {
			return maxLevel;
		}
		if(lvl > maxLevel) {
			ans.add(root.data);
			maxLevel = lvl;
		}
		maxLevel = leftViewRecursion3(root.left, ans, maxLevel, lvl+1);
		maxLevel = leftViewRecursion3(root.right, ans, maxLevel, lvl+1);
		return maxLevel;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		root.left = new BinaryTreeNode<>(2);
		root.right = new BinaryTreeNode<>(3);
		root.left.right = new BinaryTreeNode<>(4);
		root.left.left = new BinaryTreeNode<>(5);
		root.right.right = new BinaryTreeNode<>(6);
		root.right.left = new BinaryTreeNode<>(7);
		root.right.left.right = new BinaryTreeNode<>(8);

		ArrayList<Integer> ans = leftView(root);
		System.out.println("Left View (Iterative): " + ans);

		ArrayList<Integer> ansRec = new ArrayList<>();
		leftViewRecursion(root, ansRec, 0);
		System.out.println("Left View (Recursive): " + ansRec);
	}
}
