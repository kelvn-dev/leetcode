package datastructure;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class TreeTraversal {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new NodeTree(1);
    tree.root.left = new NodeTree(2);
    tree.root.right = new NodeTree(3);
    tree.root.right.right = new NodeTree(6);
    tree.root.right.right.right = new NodeTree(8);
    tree.root.left.left = new NodeTree(4);
    tree.root.left.right = new NodeTree(5);
    tree.root.left.left.left = new NodeTree(7);
    tree.root.left.left.left.right = new NodeTree(9);
    tree.printInorder(tree.root);
  }
}

/*
                            1
                           / \
                          2   3
                         / \   \
                        4   5   6
                       /         \
                      7           8
                       \
                        9
 */

/**
 * A Binary Tree is a data structure in which each node has at most two children (left child and the right child)
 * DFS (Depth First Search) O(n):
 * - Preorder => Root, Left, Right.
 * - Inorder => Left, Root, Right.
 * - Postorder => Left, Right, Root.
 */
class BinaryTree {
  NodeTree root;

  public void printPreorder(NodeTree node) {
    if (Objects.isNull(node)) {
      return;
    }
    System.out.print(node.data + " ");
    printPreorder(node.left);
    printPreorder(node.right);
  }

  public void printInorder(NodeTree node) {
    if (Objects.isNull(node)) {
      return;
    }
    printInorder(node.left);
    System.out.print(node.data + " ");
    printInorder(node.right);
  }

  public void printPostorder(NodeTree node) {
    if (Objects.isNull(node)) {
      return;
    }
    printPostorder(node.left);
    printPostorder(node.right);
    System.out.print(node.data + " ");
  }

  // BFS (Level Order): O(n)
  public void printLevelOrder() {
    if (Objects.isNull(root)) {
      return;
    }

    Queue<NodeTree> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      NodeTree node = queue.poll();
      System.out.print(node.data + " ");
      if (!Objects.isNull(node.left)) {
        queue.add(node.left);
      }
      if (!Objects.isNull(node.right)) {
        queue.add(node.right);
      }
    }

  }
}