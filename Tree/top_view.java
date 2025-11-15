import java.util.ArrayDeque;
import java.util.Queue;

public class top_view {
    
    private static void findSize(BinaryTreeNode<Integer> root, int []config, int pos) {
		if(root == null) {
			return;
		}
		config[0] = Math.min(config[0], pos);
		config[1] = Math.max(config[1], pos);
		
		findSize(root.left, config, pos-1);
		findSize(root.right, config, pos+1);
	}

    public static int[] topView(BinaryTreeNode<Integer> root){
		int[] config = new int[2];
		findSize(root, config, 0);
		int left = config[0];
		int right = config[1];
		int[] ans = new int[right-left+1];
		int[] isFilled = new int[right-left+1];
		System.out.println("left: " + left + " right: " + right);
		Queue<BinaryTreeNode<Integer>> pendingNode = new ArrayDeque<>();
		Queue<Integer> posNode = new ArrayDeque<>();
		pendingNode.offer(root);
		posNode.offer(Math.abs(left));
		while(!pendingNode.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingNode.poll();
			int pos = posNode.poll();
			if(isFilled[pos] == 0){
				isFilled[pos] = 1;
				ans[pos] = front.data;				
			}
			if(front.left != null) {
				pendingNode.offer(front.left);
				posNode.offer(pos-1);
			}
			if(front.right != null) {
				pendingNode.offer(front.right);
				posNode.offer(pos+1);
			}
			
		}
		return ans;
	}
	
    public static int[] topViewRecursion(BinaryTreeNode<Integer> root) {
		int []lr = {0, 0};
		findSize(root, lr, 0);
		int []ans = new int[lr[1]-lr[0]+1];
		helperTopView(root, ans, Math.abs(lr[0]));
		return ans;
	}
	
	private static void helperTopView(BinaryTreeNode<Integer> root, int[] ans, int pos) {
		if(root == null) {
			return;
		}
		if(ans[pos] == 0) {
			ans[pos] = root.data;
		}
		helperTopView(root.left, ans, pos-1);
		helperTopView(root.right, ans, pos+1);
	}

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(6);
        root.right.left = new BinaryTreeNode<>(7);
        root.left.left.left = new BinaryTreeNode<>(8);
        root.left.left.right = new BinaryTreeNode<>(9);

        int[] resultIterative = topView(root);
        System.out.print("Top View (Iterative): ");
        for(int val : resultIterative) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] resultRecursive = topViewRecursion(root);
        System.out.print("Top View (Recursive): ");
        for(int val : resultRecursive) {
            System.out.print(val + " ");
        }
    }
	
}
