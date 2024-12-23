package datastructure;

import java.util.Objects;

/**
 * The left subtree of a node contains only nodes with keys lesser than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 */
public class BinarySearchTree {

  NodeTree root;

  public BinarySearchTree() {
    root = null;
  }

  public BinarySearchTree(int data) {
    root = new NodeTree(data);
  }

  public void insert(int data) {
    root = insertRecur(root, data);
  }

  public NodeTree insertRecur(NodeTree root, int data) {
    if (Objects.isNull(root)) {
      return new NodeTree(data);
    }

    if (data < root.data) {
      root.left = insertRecur(root.left, data);
    } else if (data > root.data) {
      root.right = insertRecur(root.right, data);
    }
    return root;
  }

  public NodeTree search(NodeTree root, int data) {
    if (Objects.isNull(root) || root.data == data) {
      return root;
    }
    if (data < root.data) {
      return search(root.left, data);
    }
    return search(root.right, data);
  }

  public int sumOneChildNodes(NodeTree x) {
    if(x == null) return 0;
    return (((x.left == null && x.right != null) || (x.left != null && x.right == null)) ?
            x.data : 0) + sumOneChildNodes(x.left) + sumOneChildNodes(x.right);
  }

  public int maxOfLevel(NodeTree x, int level){
    if(x == null) {
      return -1;
    }
    if(level == 0) {
      return x.data;
    }
    return Math.max(maxOfLevel(x.left, level - 1), maxOfLevel(x.right, level - 1));
  }

  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(70);
    tree.insert(60);
    tree.insert(80);
    NodeTree node = tree.search(tree.root, 80);
    System.out.println(node);
  }
}
