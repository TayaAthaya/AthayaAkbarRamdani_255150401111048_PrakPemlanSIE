package DoubleLinkedListProject;

public class DoubleLinkedList {

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
            head.prev = data;
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
            data.prev = tail;
            tail = data;
        }
        size++;
    }

    // Print dari depan (soal 4)
    void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Soal 7 - Print dari belakang
    void printReverse() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    // Soal 8a - Cari by nilai
    Node findByValue(Object val) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(val)) return current;
            current = current.next;
        }
        return null;
    }

    // Soal 8b - Cari by indeks
    Node findByIndex(int n) {
        if (n < 0 || n >= size) return null;
        Node current = head;
        for (int i = 0; i < n; i++) current = current.next;
        return current;
    }

    // Soal 8c - Hapus by indeks
    void removeByIndex(int n) {
        if (n < 0 || n >= size) return;
        Node target = findByIndex(n);
        if (target == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            size--;
            return;
        }
        if (target == tail) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }
        target.prev.next = target.next;
        target.next.prev = target.prev;
        size--;
    }

    // Soal 8d - Hapus by nilai
    void removeByValue(Object val) {
        Node target = findByValue(val);
        if (target == null) return;
        if (target == head) { removeByIndex(0); return; }
        if (target == tail) { removeByIndex(size - 1); return; }
        target.prev.next = target.next;
        target.next.prev = target.prev;
        size--;
    }

    // Soal 8e - Tambah by indeks
    void addAtIndex(int n, Node data) {
        if (n <= 0) { addFirst(data); return; }
        if (n >= size) { addLast(data); return; }
        Node current = findByIndex(n);
        data.next = current;
        data.prev = current.prev;
        current.prev.next = data;
        current.prev = data;
        size++;
    }

    // Soal 8f - Tambah setelah nilai
    void addAfterValue(Object val, Node data) {
        Node current = findByValue(val);
        if (current == null) return;
        if (current == tail) { addLast(data); return; }
        data.next = current.next;
        data.prev = current;
        current.next.prev = data;
        current.next = data;
        size++;
    }

    // Soal 8g - Tambah sebelum nilai
    void addBeforeValue(Object val, Node data) {
        Node current = findByValue(val);
        if (current == null) return;
        if (current == head) { addFirst(data); return; }
        data.next = current;
        data.prev = current.prev;
        current.prev.next = data;
        current.prev = data;
        size++;
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        // Soal 4 - addFirst + addLast
        list.addFirst(nodeA);
        System.out.println("head: " + list.head.data + ", tail: " + list.tail.data);

        list.addLast(nodeB);
        System.out.println("head: " + list.head.data + ", tail: " + list.tail.data);

        list.addLast(nodeC);
        System.out.println("head: " + list.head.data + ", tail: " + list.tail.data);

        System.out.println("--- print() ---");
        list.print();

        // Soal 6
        System.out.println("Next of B: " + nodeB.next.data);
        System.out.println("Prev of B: " + nodeB.prev.data);

        // Soal 7
        System.out.println("--- printReverse() ---");
        list.printReverse();

        // Soal 8 - uji semua method
        System.out.println("--- findByValue(B): " + list.findByValue("B").data);
        System.out.println("--- findByIndex(2): " + list.findByIndex(2).data);

        list.removeByIndex(1);
        System.out.print("removeByIndex(1): "); list.print();

        list.removeByValue("A");
        System.out.print("removeByValue(A): "); list.print();

        list.addLast(new Node("A"));
        list.addLast(new Node("B"));
        list.addAtIndex(1, new Node("X"));
        System.out.print("addAtIndex(1,X): "); list.print();

        list.addAfterValue("X", new Node("Y"));
        System.out.print("addAfterValue(X,Y): "); list.print();

        list.addBeforeValue("X", new Node("Z"));
        System.out.print("addBeforeValue(X,Z): "); list.print();

        System.out.println("--- printReverse() final ---");
        list.printReverse();
    }
}