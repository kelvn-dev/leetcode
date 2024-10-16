import java.util.Objects;

public class BinarySearchTree {
  class Node {
    int key;
    Node left, right;

    public Node(int key) {
      this.key = key;
      left = right = null;
    }
  }

  Node root;

  public BinarySearchTree() {
    root = null;
  }

  public BinarySearchTree(int key) {
    root = new Node(key);
  }

  public void insert(int key) {
    root = insertRecur(root, key);
  }

  public Node insertRecur(Node root, int key) {
    if (Objects.isNull(root)) {
      return new Node(key);
    }

    if (key < root.key) {
      root.left = insertRecur(root.left, key);
    } else if (key > root.key) {
      root.right = insertRecur(root.right, key);
    }
    return root;
  }

  public Node search(Node root, int key) {
    if (Objects.isNull(root) || root.key == key) {
      return root;
    }
    if (key < root.key) {
      return search(root.left, key);
    }
    return search(root.right, key);
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
    Node node = tree.search(tree.root, 90);
    System.out.println(node);
  }
}
