/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int maxSum = Integer.MIN_VALUE;

    private int depthFirstSearch(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, depthFirstSearch(node.left));
        int rightSum = Math.max(0, depthFirstSearch(node.right));

        int currentPath = node.val + leftSum + rightSum;

        maxSum = Math.max(maxSum, currentPath);

        return node.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        depthFirstSearch(root);
        return maxSum;

        /*int maxSum = Integer.MIN_VALUE;

        int leftSum;
        int rightSum;
        int[] vals;

        if(root == null) return -99999999;
        if(root.left == null && root.right == null) return root.val;
        if(root.left == null){ 
            rightSum = maxPathSum(root.right);
            vals = new int[]{rightSum, rightSum + root.val, root.val};
            for(int e : vals) maxSum = Math.max(e, maxSum);
            return maxSum;
        }
        if(root.right == null) {
            leftSum = maxPathSum(root.left);
            vals = new int[]{leftSum, leftSum + root.val, root.val};
            for(int e : vals) maxSum = Math.max(e, maxSum);
            return maxSum;
        }

        leftSum  = maxPathSum(root.left);
        rightSum = maxPathSum(root.right);
        vals = new int[]{leftSum, rightSum, leftSum + root.val, rightSum + root.val, root.val, leftSum + rightSum + root.val};
        for(int e : vals) maxSum = Math.max(e, maxSum);

        return maxSum;*/
    }
}
