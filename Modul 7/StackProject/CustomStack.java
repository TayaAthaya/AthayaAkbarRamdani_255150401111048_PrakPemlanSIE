package StackProject;

public class CustomStack {
    Node top;
    int size = 0;

    public void push(int x) {
        Node n = new Node(x);
        n.next = top;
        top = n;
        size++;
    }
    
    public int pop() {
        if (top == null)
            throw new RuntimeException("Stack is empty.");
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }
    
    public boolean isEmpty() {
        return top == null;
    }

    // Soal 2 - tambahkan peek()
    public int peek() {
        if (top == null)
            throw new RuntimeException("Stack is empty.");
        return top.data;
    }

    public static void main(String[] args) {
        // === Soal 1 ===
        CustomStack custom = new CustomStack();
        custom.push(1);
        custom.push(2);
        custom.push(3);
        System.out.print("Custom Stack: ");
        while (!custom.isEmpty()) {
            System.out.print("[" + custom.pop() + "]");
        }
        System.out.println("End.");


        // === Soal 3 - pop() saat kosong -> RuntimeException ===
        // Jangan lakukan ini: custom.pop() setelah isEmpty()!
        // System.out.println(custom.pop());
        

        // === Soal 2 - demo peek() ===
        custom.push(10);
        custom.push(20);
        System.out.println("Peek: " + custom.peek()); // 20
        System.out.println("Peek lagi: " + custom.peek()); // masih 20, tidak berubah


        // === Soal 4 - sisipkan 5 di posisi ke-2 dari bawah ===
        CustomStack cs = new CustomStack();
        cs.push(1); cs.push(2); cs.push(3); cs.push(4);
        // Urutan stack (bawah -> atas): 1,2,3,4 -> top =4

        CustomStack temp = new CustomStack();
        temp.push(cs.pop()); // ambil 4
        temp.push(cs.pop()); // ambil 3
        temp.push(cs.pop()); // ambil 2
        cs.push(5);          // masukkan 5 setelah 1
        while (!temp.isEmpty()) cs.push(temp.pop()); // kembalikan 2,3,4

        System.out.print("Hasil: ");
        while (!cs.isEmpty()) System.out.print("[" + cs.pop() + "]");
        System.out.println("End.");

    }
}
