import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class diagonalTraversal {

    private static void findLeftMost(BinaryTreeNode<Integer> root, int[] left, int pos) {
        if (root == null) {
            return;
        }
        left[0] = Math.max(left[0], pos);
        findLeftMost(root.left, left, pos + 1);
        findLeftMost(root.right, left, pos);
    }

    private static void helperDiagonal(BinaryTreeNode<Integer> root, List<Integer>[] res, int pos) {
        if (root == null) {
            return;
        }
        if (res[pos] == null) {
            res[pos] = new ArrayList<>();
        }
        res[pos].add(root.data);
        helperDiagonal(root.left, res, pos + 1);
        helperDiagonal(root.right, res, pos);
    }

    // Using DFS
    public static List<Integer> diagonalOrderTraversal(BinaryTreeNode<Integer> root) {
        int[] left = { 0 };
        findLeftMost(root, left, 0);
        List<Integer> ans = new ArrayList<>();
        List<Integer>[] res = new ArrayList[left[0] + 1];
        helperDiagonal(root, res, 0);
        for (int i = 0; i < res.length; i++) {
            ans.addAll(res[i]);
        }
        return ans;
    }

    // Alternative approach using queue
    public static List<Integer> diagonalOrderTraversal2(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> pendingNode = new ArrayDeque<>();
        pendingNode.offer(root);
        while (!pendingNode.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingNode.poll();
            while (front != null) {
                ans.add(front.data);
                if (front.left != null) {
                    pendingNode.offer(front.left);
                }
                front = front.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(8);
        root.left = new BinaryTreeNode<>(3);
        root.right = new BinaryTreeNode<>(10);
        root.left.left = new BinaryTreeNode<>(1);
        root.left.right = new BinaryTreeNode<>(6);
        root.left.right.left = new BinaryTreeNode<>(4);
        root.left.right.right = new BinaryTreeNode<>(7);
        root.right.right = new BinaryTreeNode<>(14);
        root.right.right.left = new BinaryTreeNode<>(13);

        List<Integer> result = diagonalOrderTraversal(root);
        List<Integer> result2 = diagonalOrderTraversal2(root);
        System.out.println(result);
        System.out.println(result2);
    }

}
