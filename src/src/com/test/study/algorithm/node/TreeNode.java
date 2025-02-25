package src.com.test.study.algorithm.node;

import com.sun.source.tree.Tree;

import java.util.Objects;

/**
 * @Classname TreeNode
 * @Description TODO
 * @Date 2025/02/20 10:48
 * @Created by Bruce
 */
public class TreeNode {
    int val;
    TreeNode leftNode;
    TreeNode rightNode;

    TreeNode (int val){
        this.val = val;
        this.leftNode = null;
        this.rightNode = null;
    }

    public static TreeNode changeTreeNode(TreeNode root){

        if(root ==  null){
            return null;
        }
        TreeNode temp = root.leftNode;
        root.leftNode = changeTreeNode(root.rightNode);
        root.rightNode = changeTreeNode(temp);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.leftNode = new TreeNode(2);
        root.leftNode.leftNode = new TreeNode(1);
        root.leftNode.rightNode = new TreeNode(3);
        root.rightNode = new TreeNode(7);
        root.rightNode.leftNode = new TreeNode(6);
        root.rightNode.rightNode =new TreeNode(9);
        System.out.println("原始二叉树：");
        preOrderTraversal(root);
        System.out.println("反转以后的二叉树");
        TreeNode res = changeTreeNode(root);
        preOrderTraversal(res);
    }

    // 先序遍历二叉树
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print("当前节点node是："+node.val + " ");  // 打印当前节点的值
        preOrderTraversal(node.leftNode);      // 递归遍历左子树
        preOrderTraversal(node.rightNode);     // 递归遍历右子树
    }
}
