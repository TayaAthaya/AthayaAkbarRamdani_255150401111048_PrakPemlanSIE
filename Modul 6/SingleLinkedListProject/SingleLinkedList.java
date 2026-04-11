package SingleLinkedListProject;

public class SingleLinkedList {

    Node head, tail;
    int size = 0;

    void init() { head = null; }
    boolean isEmpty() { return size == 0; }
    int size() { return size; }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            tail = data;
        }
        size++;
    }

    // a. Cari by nilai
    Node findByValue(Object val) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(val)) return current;
            current = current.next;
        }
        return null;
    }

    // b. Cari by indeks
    Node findByIndex(int n) {
        if (n < 0 || n >= size) return null;
        Node current = head;
        for (int i = 0; i < n; i++) current = current.next;
        return current;
    }

    // c. Hapus by indeks
    void removeByIndex(int n) {
        if (n < 0 || n >= size) return;
        if (n == 0) {
            head = head.next;
            if (size == 1) tail = null;
            size--;
            return;
        }
        Node prev = findByIndex(n - 1);
        if (prev.next == tail) tail = prev;
        prev.next = prev.next.next;
        size--;
    }

    // d. Hapus by nilai
    void removeByValue(Object val) {
        if (isEmpty()) return;
        if (head.data.equals(val)) { removeByIndex(0); return; }
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.data.equals(val)) {
                if (prev.next == tail) tail = prev;
                prev.next = prev.next.next;
                size--;
                return;
            }
            prev = prev.next;
        }
    }

    // e. Tambah by indeks
    void addAtIndex(int n, Node data) {
        if (n <= 0) { addFirst(data); return; }
        if (n >= size) { addLast(data); return; }
        Node prev = findByIndex(n - 1);
        data.next = prev.next;
        prev.next = data;
        size++;
    }

    // f. Tambah setelah nilai tertentu
    void addAfterValue(Object val, Node data) {
        Node current = findByValue(val);
        if (current == null) return;
        data.next = current.next;
        current.next = data;
        if (current == tail) tail = data;
        size++;
    }

    // g. Tambah sebelum nilai tertentu
    void addBeforeValue(Object val, Node data) {
        if (isEmpty()) return;
        if (head.data.equals(val)) { addFirst(data); return; }
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.data.equals(val)) {
                data.next = prev.next;
                prev.next = data;
                size++;
                return;
            }
            prev = prev.next;
        }
    }

    // Helper print
    void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /*public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        System.out.println("Head: " + list.head);
        System.out.println("Tail: " + list.tail);

        list.addFirst(new Node("A"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);

        list.addFirst(new Node("B"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);

        list.addLast(new Node("C"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);
    }*/

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(new Node("A"));
        list.addLast(new Node("B"));
        list.addLast(new Node("C"));
        list.print(); // A -> B -> C -> null

        // a. findByValue
        Node found = list.findByValue("B");
        System.out.println("findByValue(B): " + found.data);

        // b. findByIndex
        Node idx = list.findByIndex(2);
        System.out.println("findByIndex(2): " + idx.data);

        // c. removeByIndex
        list.removeByIndex(1);
        list.print(); // A -> C -> null

        // d. removeByValue
        list.removeByValue("A");
        list.print(); // C -> null

        // Isi ulang untuk uji e, f, g
        list.addLast(new Node("A"));
        list.addLast(new Node("B"));
        list.print(); // C -> A -> B -> null

        // e. addAtIndex
        list.addAtIndex(1, new Node("X"));
        list.print(); // C -> X -> A -> B -> null

        // f. addAfterValue
        list.addAfterValue("X", new Node("Y"));
        list.print(); // C -> X -> Y -> A -> B -> null

        // g. addBeforeValue
        list.addBeforeValue("X", new Node("Z"));
        list.print(); // C -> Z -> X -> Y -> A -> B -> null
    }
}