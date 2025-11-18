public class constructTree {

    // Construct Tree from Preorder and Inorder
    public static BinaryTreeNode<Integer> preorderAndInorder(int[] preorder, int[] inorder, int start, int end, int index) {
        if (start > end) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorder[index]);
        int pos = find(inorder, preorder[index], start, end);
        root.left = preorderAndInorder(preorder, inorder, start, pos - 1, index + 1);
        root.right = preorderAndInorder(preorder, inorder, pos + 1, end, index + (pos - start) + 1);
        return root;
    }

    // Construct Tree from Postorder and Inorder
    public static BinaryTreeNode<Integer> postorderAndInorder(int[] postorder, int[] inorder, int start, int end,
            int index) {
        if (start > end) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(postorder[index]);
        int pos = find(inorder, postorder[index], start, end);
        root.right = postorderAndInorder(postorder, inorder, pos + 1, end, index - 1);
        root.left = postorderAndInorder(postorder, inorder, start, pos - 1, index - (end - pos) - 1);
        return root;
    }

    // Helper function to find the index of a value in inorder array
    private static int find(int[] inorder, int val, int start, int end) {
        for (int i = start; i < end; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

}
