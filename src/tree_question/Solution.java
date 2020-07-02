package tree_question;

import java.util.*;

public class Solution {

    List<Integer> list = new ArrayList<Integer>();

    //104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        if(root==null)  return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int h = Math.max(left,right)+1;
        return h;
    }

    //543. Diameter of Binary Tree
    //Given a binary tree, you need to compute the length of the diameter of the tree. 
    //The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
    int d;
    public int diameterOfBinaryTree(TreeNode root) {
        d = 1;
        maxDepth1(root);
        return d - 1;
        
    }
    public int maxDepth1(TreeNode root) {
        if(root==null)  return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int h = Math.max(left,right)+1;
        d = Math.max(d,left+right+1);
        return h;
    }
    //101. Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }
    public boolean symmetric(TreeNode left, TreeNode right){
        if(left == null && right == null)   return true;
        if(left == null || right == null)  return false;
        return (left.val == right.val) && symmetric(left.right, right.left) && symmetric(left.left, right.right);
    }
    //144. Binary Tree Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return list;
    }
    public void preorder(TreeNode root) {
        if(root == null)    return;
        if (root!=null){
            list.add(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    //145. Binary Tree Postorder Traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return list;
    }
     public void postorder(TreeNode root) {
        if(root == null)    return;
        if (root!=null){
            postorder(root.left);
            postorder(root.right);
            list.add(root.val);
        }
    }

     //94. Binary Tree Inorder Traversal
     public List<Integer> inorderTraversal(TreeNode root) {
         inorder(root);
         return list;
     }
     public void inorder(TreeNode root) {
         if(root == null)    return;
         if(root!=null){
             inorder(root.left);
             list.add(root.val);
             inorder(root.right);   
         }
     }
     //98. Validate Binary Search Tree == on inorder traverse BST will give ascending order number 
     public boolean isValidBST(TreeNode root) {
		inorder1(root);
		int array[] = list.stream().mapToInt(Integer::intValue).toArray();
		for (int i = 0; i < array.length-1; i++) {
			if(array[i]>=array[i+1])
			return false;
		}
	return true;
	}
    public void inorder1(TreeNode root) {
        if(root == null)    return;
        if(root!=null){
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);   
        }
    }
     
     //103. Binary Tree Zigzag Level Order Traversal
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         
 		List<List<Integer>> list = new ArrayList<List<Integer>>();
 		Stack<TreeNode> stack1 = new Stack<>();	//left to right
 		Stack<TreeNode> stack2 = new Stack<>(); //right to left
        
 		if(root == null)		
             return  list;
 		stack1.push(root); 
 		List<Integer> level = new ArrayList<Integer>();
 		
 		while(!stack1.isEmpty()) {
 			while(!stack1.isEmpty()) {
 				TreeNode t = stack1.pop();
                 level.add(t.val);
 				if(t.left!=null)	
                     stack2.push(t.left);
 				if(t.right!=null)	
                     stack2.push(t.right);
 			}
 			if(!level.isEmpty())	
                 list.add(new ArrayList<Integer>(level));
 			level.clear();
 			while(!stack2.isEmpty()) {
 				TreeNode t = stack2.pop();
                 level.add(t.val);
 				if(t.right!=null)	
                     stack1.push(t.right);
 				if(t.left!=null)	
                     stack1.push(t.left);
 			}
 			if(!level.isEmpty())	
                 list.add(new ArrayList<Integer>(level));
 			level.clear();
 		}
 		return list;  
     }
     //102. Binary Tree Level Order Traversal
     public List<List<Integer>> levelOrder(TreeNode root) {
         
         List<List<Integer>> list = new ArrayList<List<Integer>>();
 		Queue<TreeNode> queue1 = new ArrayDeque<>();
 		Queue<TreeNode> queue2 = new ArrayDeque<>();
         
 		if(root== null)		
             return  list;
 		queue1.add(root);
 		List<Integer> level = new ArrayList<Integer>();
 		while(!queue1.isEmpty() || !queue2.isEmpty()) {
 			while(!queue1.isEmpty()) {
 				queue2 = queueOperation(queue1,level,list);
 			}
 			while(!queue2.isEmpty()) {
 				queue1 = queueOperation(queue2,level,list);
 				
 			}
 		}
         return list;
     }
     public Queue queueOperation(Queue<TreeNode> queue1,List<Integer> level,List<List<Integer>> list) {
 		Queue<TreeNode> tempQueue = new ArrayDeque<>();
 		while(!queue1.isEmpty()) {
 			TreeNode t = queue1.remove();
 			level.add(t.val);
 			if(t.left!=null)
 				tempQueue.add(t.left);
 			if(t.right!=null)
 				tempQueue.add(t.right);
 		}
 		if(!level.isEmpty())
 			list.add(new ArrayList<Integer>(level));
 		level.clear();
 		return tempQueue;
 	}
     //110. Balanced Binary Tree
     public boolean isBalanced(TreeNode root) {
         if(root==null || root.left == null && root.right==null)
             return true;
         int left = height(root.left);
         int right = height(root.right);
        // int diff = (left - right)<0 ? -(left - right) : (left - right);
         if(Math.abs(left - right)<2)
             return true;
         else 
             return false;
     }
	public int height(TreeNode root) {
		if(root == null)	return 0;
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right)+1;
	}
	
	public static TreeNode invertTree(TreeNode root) {
		if(root==null)
			return null;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
        
    }
 
}
