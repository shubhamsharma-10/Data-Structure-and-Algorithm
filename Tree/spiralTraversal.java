import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class spiralTraversal {

    public static List<List<Integer>> spiralOrderTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<BinaryTreeNode<Integer>> stack1 = new ArrayDeque<>();
        Deque<BinaryTreeNode<Integer>> stack2 = new ArrayDeque<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                List<Integer> tempAns = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    BinaryTreeNode<Integer> front = stack1.pop();
                    tempAns.add(front.data);
                    if (front.left != null) {
                        stack2.push(front.left);
                    }
                    if (front.right != null) {
                        stack2.push(front.right);
                    }
                }
                ans.add(tempAns);
            }

            if (!stack2.isEmpty()) {
                List<Integer> tempAns = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    BinaryTreeNode<Integer> front = stack2.pop();
                    tempAns.add(front.data);
                    if (front.right != null) {
                        stack1.push(front.right);
                    }
                    if (front.left != null) {
                        stack1.push(front.left);
                    }
                }
                ans.add(tempAns);
            }
        }
        return ans;
    }

    public static List<List<Integer>> spiralOrderTraversal2(BinaryTreeNode<Integer> root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<BinaryTreeNode<Integer>> pendingNode = new ArrayDeque<>();
        pendingNode.offer(root);
        int flag = 0;
        while (!pendingNode.isEmpty()) {
            int n = pendingNode.size();
            List<Integer> tempAns = new ArrayList<>();
            while (n != 0) {
                BinaryTreeNode<Integer> front = pendingNode.poll();
                tempAns.add(front.data);
                if (front.left != null) {
                    pendingNode.offer(front.left);
                }
                if (front.right != null) {
                    pendingNode.offer(front.right);
                }
                n--;
            }
            if (flag == 1) {
                int i = 0;
                int k = tempAns.size() - 1;
                while (i < k) {
                    int temp = tempAns.get(i);
                    tempAns.set(i, tempAns.get(k));
                    tempAns.set(k, temp);
                    i++;
                    k--;
                }
                flag = 0;
            } else {
                flag = 1;
            }
            ans.add(tempAns);
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        List<List<Integer>> ans = spiralOrderTraversal(root);
        System.out.println("Spiral Order Traversal (Using Two Stacks): " + ans);

        List<List<Integer>> ans2 = spiralOrderTraversal2(root);
        System.out.println("Spiral Order Traversal (Using Queue): " + ans2);
    }
}
