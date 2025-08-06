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
    private String ans = "~"; 
    
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }
    
    private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) return;
        
        path.insert(0, (char)(node.val + 'a'));
                if (node.left == null && node.right == null) {
            String current = path.toString();
            if (current.compareTo(ans) < 0) {
                ans = current;
            }
        }
        
        dfs(node.left, path);
        dfs(node.right, path);
                path.deleteCharAt(0);
    }
}