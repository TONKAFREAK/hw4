import java.io.FileWriter;
import java.io.PrintWriter;

class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;

        }
    }

    private Node root;

    // ------ Methods ---------

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // -------------------------

    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null)
            return root;

        if (value < root.data) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.data) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // ------------ Traversals ------------

    public void inorder(PrintWriter pw) throws Exception {
        inorderRec(root, pw);
        pw.println();
    }

    private void inorderRec(Node root, PrintWriter pw) {
        if (root != null) {
            inorderRec(root.left, pw);
            pw.print(root.data + " ");
            inorderRec(root.right, pw);
        }
    }

    // -------------------------

    public void preorder(PrintWriter pw) {
        preorderRec(root, pw);
        pw.println();
    }

    private void preorderRec(Node root, PrintWriter pw) {
        if (root != null) {
            pw.print(root.data + " ");
            preorderRec(root.left, pw);
            preorderRec(root.right, pw);
        }
    }

    // -------------------------

    public void postorder(PrintWriter pw) {
        postorderRec(root, pw);
        pw.println();
    }

    private void postorderRec(Node root, PrintWriter pw) {
        if (root != null) {
            postorderRec(root.left, pw);
            postorderRec(root.right, pw);
            pw.print(root.data + " ");
        }
    }

    // ---------- Util methods ------------

    public int count() {
        return countRec(root);
    }

    private int countRec(Node root) {
        if (root == null)
            return 0;
        return 1 + countRec(root.left) + countRec(root.right);
    }

    public void printChildren(PrintWriter pw) {
        printChildrenRec(root, pw);
    }

    private void printChildrenRec(Node root, PrintWriter pw) {
        if (root != null) {
            int children = (root.left != null ? 1 : 0) + (root.right != null ? 1 : 0);
            pw.println("Node \"" + root.data + "\" has " + children + " children.");
            printChildrenRec(root.left, pw);
            printChildrenRec(root.right, pw);
        }
    }
}