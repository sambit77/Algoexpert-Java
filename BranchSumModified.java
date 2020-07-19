Problem :- https://leetcode.com/problems/path-sum/submissions/
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
    public boolean hasPathSum(TreeNode root, int sum) {
        ArrayList<Integer> sums = computeAllSum(root);
        for(int s : sums)
        {
            if(s==sum)
            {
                return true;
            }
        }
        return false;
    }
    public static ArrayList<Integer> computeAllSum(TreeNode root)
    {
        ArrayList<Integer> sums = new ArrayList<Integer>();
        computeAllSumHelper(root,0,sums);
        return sums;
    }
    public static void computeAllSumHelper(TreeNode root,int sum,ArrayList<Integer> sums)
    {
        if(root == null)
        {
            return;
        }
        sum = sum+root.val;
        if(root.left == null && root.right == null)
        {
            sums.add(sum);
            return;
        }
        computeAllSumHelper(root.left,sum,sums);
        computeAllSumHelper(root.right,sum,sums);
     
    }
}
