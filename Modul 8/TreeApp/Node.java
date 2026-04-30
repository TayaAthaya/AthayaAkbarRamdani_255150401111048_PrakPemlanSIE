package TreeApp;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }

    public void add(int data) {
        if (data > this.data) {
            if (this.right == null) {
                this.right = new Node(data);
            } else this.right.add(data);
        }
        if (data < this.data) {
            if (this.left == null) {
                this.left = new Node(data);
            } else this.left.add(data);
        }
    }
}

/*class Node {
    String data;       // ← int → String
    Node left, right;

    Node(String data) {  // ← int → String
        this.data = data;
    }

    public void add(String data) {  // ← int → String
        if (data.compareTo(this.data) > 0) {  // ← > diganti compareTo
            if (this.right == null) {
                this.right = new Node(data);
            } else this.right.add(data);
        }
        if (data.compareTo(this.data) < 0) {  // ← < diganti compareTo
            if (this.left == null) {
                this.left = new Node(data);
            } else this.left.add(data);
        }
    }
}*/