import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class TreeTraversal {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.right.right = new Node(6);
    tree.root.right.right.right = new Node(8);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.left.left.left = new Node(7);
    tree.root.left.left.left.right = new Node(9);
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

class Node {
  int data;
  Node left, right;

  public Node(int data) {
    this.data = data;
    left = right = null;
  }
}

/*
DFS (Depth First Search) O(n)
Preorder => Root, Left, Right.
Inorder => Left, Root, Right.
Postorder => Left, Right, Root.
 */
class BinaryTree {
  Node root;

  public void printPreorder(Node node) {
    if (Objects.isNull(node)) {
      return;
    }
    System.out.print(node.data + " ");
    printPreorder(node.left);
    printPreorder(node.right);
  }

  public void printInorder(Node node) {
    if (Objects.isNull(node)) {
      return;
    }
    printInorder(node.left);
    System.out.print(node.data + " ");
    printInorder(node.right);
  }

  public void printPostorder(Node node) {
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

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node node = queue.poll();
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