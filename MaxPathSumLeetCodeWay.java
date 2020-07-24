//Problem Link:- https://leetcode.com/problems/binary-tree-maximum-path-sum/
//All test cases passed in LeetCode
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
    
    private int globalMaximumSum;
    
    public int maxPathSum(TreeNode root) {
        globalMaximumSum = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return globalMaximumSum;
    }
    
    private int findMaxPathSum(TreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }
        
        int maxPathSumLeft = findMaxPathSum(currentNode.left);
        int maxPathSumRight = findMaxPathSum(currentNode.right);
        
        maxPathSumLeft = Math.max(maxPathSumLeft, 0);
        maxPathSumRight = Math.max(maxPathSumRight, 0);
        
        int localPathSumMaximum = maxPathSumLeft + maxPathSumRight + currentNode.val;
        globalMaximumSum = Math.max(globalMaximumSum, localPathSumMaximum);
        return Math.max(maxPathSumLeft, maxPathSumRight) + currentNode.val;
    }  
    
}
