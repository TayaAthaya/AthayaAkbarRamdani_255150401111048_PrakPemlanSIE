package TreeApp;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;

    public void add(int data) {
        if (root == null) { root = new Node(data); return; }
        root.add(data);
    }

    public void preTraverse(Node node) {
        if (node == null) return;
        System.out.printf("[%d]", node.data);
        preTraverse(node.left);
        preTraverse(node.right);
    }

    public void inTraverse(Node node) {
        if (node == null) return;
        inTraverse(node.left);
        System.out.printf("[%d]", node.data);
        inTraverse(node.right);
    }

    public void postTraverse(Node node) {
        if (node == null) return;
        postTraverse(node.left);
        postTraverse(node.right);
        System.out.printf("[%d]", node.data);
    }

    // Soal 5
    public int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Soal 6
    public int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // Soal 7
    public int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Soal 9
    public void levelTraverse(Node node) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.printf("[%d]", current.data);
            if (current.left  != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Soal 2
        for (int i = 0; i < 10; i++) {
            int nilai = (int) (Math.random() * 100);
            System.out.printf("Nilai %d dimasukkan.\n", nilai);
            tree.add(nilai);
        }

        // Soal 4
        System.out.print("\nPreorder  : "); tree.preTraverse(tree.root);
        System.out.print("\nInorder   : "); tree.inTraverse(tree.root);
        System.out.print("\nPostorder : "); tree.postTraverse(tree.root);

        // Soal 5
        System.out.println("\nJumlah node  : " + tree.countNodes(tree.root));

        // Soal 6
        System.out.println("Jumlah daun  : " + tree.countLeaves(tree.root));

        // Soal 7
        System.out.println("Tinggi tree  : " + tree.height(tree.root));

        // Soal 9
        System.out.print("Level order  : "); tree.levelTraverse(tree.root);
        System.out.println();
    }
}


/*public class BinaryTree {

    Node root;

    public void add(String data) {   // ← int → String
        if (root == null) {
            root = new Node(data);
            return;
        }
        root.add(data);
    }

    public void preTraverse(Node node) {
        if (node == null) return;
        System.out.printf("[%s]", node.data);    // ← %d → %s
        preTraverse(node.left);
        preTraverse(node.right);
    }

    public void inTraverse(Node node) {
        if (node == null) return;
        inTraverse(node.left);
        System.out.printf("[%s]", node.data);    // ← %d → %s
        inTraverse(node.right);
    }

    public void postTraverse(Node node) {
        if (node == null) return;
        inTraverse(node.left);
        inTraverse(node.right);
        System.out.printf("[%s]", node.data);    // ← %d → %s
    }

    // Soal 5 - hitung jumlah node
    public int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Soal 6 - hitung jumlah daun
    public int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // Soal 7 - ukur tinggi tree
    public int height(Node node) {
        if (node == null) return 0;
        int leftHeight  = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        
        // Soal 2 - isi 10 angka acak
        /*BinaryTree tree = new BinaryTree();

        for (int i = 0; i < 10; i++) {
            int nilai = (int) (Math.random() * 100);
            System.out.printf("Nilai %d dimasukkan.\n", nilai);
            tree.add(nilai);
        }

        // Soal 4 - panggil ketiga traversal
        System.out.print("\nPreorder  : ");
        tree.preTraverse(tree.root);

        System.out.print("\nInorder   : ");
        tree.inTraverse(tree.root);

        System.out.print("\nPostorder : ");
        tree.postTraverse(tree.root);
        System.out.println();

        // Soal 5
        System.out.println("Jumlah node: " + tree.countNodes(tree.root));

        // Soal 6
        System.out.println("Jumlah daun: " + tree.countLeaves(tree.root));

        // Soal 7
        System.out.println("Tinggi tree: " + tree.height(tree.root)); */

        // Soal 8 - buat tree dengan tipe data String
        /*BinaryTree tree2 = new BinaryTree();
        tree2.add("Banana");
        tree2.add("Apple");
        tree2.add("Cherry");
        tree2.add("Durian");
        tree2.add("Alpukat");
        System.out.print("Inorder String: ");
        tree2.inTraverse(tree2.root);
    }

} */