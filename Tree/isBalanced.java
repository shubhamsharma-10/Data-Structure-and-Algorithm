public class isBalanced{
    // Naive Approach - O(n^2) time complexity
    public static boolean isBalanced1(BinaryTreeNode root) {
        if(root == null) {
            return true;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        
        boolean isLeftBalanced = isBalanced1(root.left);
        boolean isRightBalanced = isBalanced1(root.right);
        
        return isLeftBalanced && isRightBalanced;
    }

    private static int height(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Optimized Approach - O(n) time complexity
    public static boolean isBalanced2(BinaryTreeNode root){
        return checkBalance(root) != -1;
    }

    private static int checkBalance(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftHeight = checkBalance(root.left);
        if(leftHeight == -1) {
            return -1; 
        }
        
        int rightHeight = checkBalance(root.right);
        if(rightHeight == -1) {
            return -1;
        }
        
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        return Math.max(leftHeight, rightHeight) + 1; 
    }

    public static void main(String[] args) {
        

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(6);

        System.out.println(isBalanced1(root)); // true
        System.out.println(isBalanced2(root)); // true
    }
}