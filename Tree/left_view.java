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

	public static void leftViewRecursion(BinaryTreeNode<Integer> root, ArrayList<Integer> ans, int lvl){
		if(root == null) {
			return;
		}
		if(lvl == ans.size()) {
			ans.add(root.data);
		}
		leftViewRecursion(root.left, ans, lvl+1);
		leftViewRecursion(root.right, ans, lvl+1);
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
