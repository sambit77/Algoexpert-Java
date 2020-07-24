//Problem Link:- https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Using Algoexpert way all test cases are not passing
//(44 / 93 test cases passed.) may be  due to not considering the negataive values for eg
//if we have a tree with only node -3 , expected Output -3 , this code output 0
//Time Complexity O(n) | Space Complexity O(d) d = depth of tree , for balanced BST d = log n
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
    public int maxPathSum(TreeNode root) {
        int[] arr = maxPathSumHelper(root,0,0);
        return arr[1];
    }
    public static int[] maxPathSumHelper(TreeNode root,int maxPathSumAsBranch,int currentMaxPathSum)
    {
        if(root == null)
        {
            return new int[]{0,0};
        }
        int[] leftResults = maxPathSumHelper(root.left,maxPathSumAsBranch,currentMaxPathSum);
        int leftPathSumAsBranch =leftResults[0];
        int leftMaxSum = leftResults[1];
        int[] rightResults = maxPathSumHelper(root.right,maxPathSumAsBranch,currentMaxPathSum);
        int rightPathSumAsBranch = rightResults[0];
        int rightMaxSum = rightResults[1];
        
        int maxChildSumAsBranch = Math.max(leftPathSumAsBranch,rightPathSumAsBranch);
        int value = root.val;
        
        int maxSumAsBranch = Math.max(maxChildSumAsBranch+value,value);
        
        int maxSumWithRoot = Math.max(maxSumAsBranch,leftMaxSum+value+rightMaxSum);
        int currentMax = Math.max(Math.max(leftMaxSum,rightMaxSum),maxSumWithRoot);
        
        return new int[]{maxSumAsBranch,currentMax};
        
              
    }
}
