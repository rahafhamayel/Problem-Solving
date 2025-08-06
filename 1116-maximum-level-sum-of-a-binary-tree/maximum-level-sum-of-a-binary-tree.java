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
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        int maxLevel = 1;
        int maxSum = root.val;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int currentLevelSum = 0;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevelSum += node.val;
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                maxLevel = level;
            }
            
            level++;
        }
        
        return maxLevel;
    }
}
