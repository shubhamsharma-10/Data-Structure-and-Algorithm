import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class verticalTraversal {

    private static void findSize(BinaryTreeNode<Integer> root, int []lr, int pos){
    
        if(root == null){
            return;
        }

        lr[0] = Math.min(lr[0], pos);
        lr[1] = Math.max(lr[1], pos);
        findSize(root.left, lr, pos-1);
        findSize(root.right, lr, pos+1);

    }

    public static int[] verticalOrderTraversal(BinaryTreeNode<Integer> root){  
        if(root == null){
            return null;
        }
        int []lr = {0,0};
        findSize(root, lr, 0);

        ArrayList<Integer>[] res1 = new ArrayList[Math.abs(lr[0])];
        ArrayList<Integer>[] res2 = new ArrayList[Math.abs(lr[1])];
        int width = lr[1] - lr[0] + 1;
        int[] ans = new int[width];
        Queue<BinaryTreeNode<Integer>> pendingNodes = new ArrayDeque<>();
        Queue<Integer> positions = new ArrayDeque<>();
        pendingNodes.offer(root);
        positions.offer(Math.abs(lr[0]));
        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front = pendingNodes.poll();
            int pos = positions.poll();
            if(pos >= 0){
                if(res2[pos] == null){
                    res2[pos] = new ArrayList<>();
                }
                res2[pos].add(front.data);
            }
            
            if(pos < 0){
                if(res1[pos] == null){
                    res1[pos] = new ArrayList<>();
                }
                res1[pos].add(front.data);
            }

            if(front.left != null){
                pendingNodes.offer(front.left);
                positions.offer(pos-1);
            }
            if(front.right != null){
                pendingNodes.offer(front.right);
                positions.offer(pos+1);
            }
        }
        int a = 0;
        for(int i = res1.length-1; i > 0; i--){
            for(int k = 0; k < res1[i].size(); k++){
                ans[a] = res1[i].get(k);
                a++;
            }
        }
        for(int i = 0; i < res2.length; i++){
            for(int k = 0; k < res2[i].size(); k++){
                ans[a] = res2[i].get(k);
                a++;
            }
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
        int[] ans = verticalOrderTraversal(root);
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        
        // TODO: Implement using TreeNode class and Priority Queue for sorting within same vertical and level
    }
}