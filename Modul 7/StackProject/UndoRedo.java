package StackProject;

import java.util.Scanner;
import java.util.Stack;

public class UndoRedo {
    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();
    
    public void action(String command) {
        System.out.println("Action: " + command);
        undoStack.push(command);
        redoStack.clear();
        UndoRedo.print(undoStack);
    }

    public void undo() {
        if (undoStack.isEmpty())
            System.out.println("Nothing to undo.");
        else {
            // Soal No 1
            // Pindahkan command dari undoStack ke redoStack
            String cmd = undoStack.pop();
            redoStack.push(cmd);
            System.out.println("Undo: " + cmd);
        }
        // UndoRedo.print(undoStack); // <- tampilkan undoStack setelah undo (No 1)
        printAll(undoStack, redoStack); // <- tampilkan kedua stack setelah undo (No 2)
    }
        
    public void redo() {
        if (redoStack.isEmpty())
            System.out.println("Nothing to redo.");
        else {
            // Soal No 1
            // Pindahkan command dari redoStack ke undoStack
            String cmd = redoStack.pop();
            undoStack.push(cmd);
            System.out.println("Redo: " + cmd);
        }
        // UndoRedo.print(undoStack); // <- tampilkan undoStack setelah redo (No 1)
        printAll(undoStack, redoStack); // <- tampilkan kedua stack setelah redo (No 2)
    }
        
    public static void print(Stack<String> stack) {
        System.out.print("Stack Undo: ");
        for(String s: stack)
            System.out.print(s + " ");
        System.out.println();
    }

    // Soal 2 - print kedua stack
    public static void printAll(Stack<String> undo, Stack<String> redo) {
        System.out.print("Stack Undo: ");
        for (String s : undo) System.out.print(s + " ");
        System.out.println();
        System.out.print("Stack Redo: ");
        for (String s : redo) System.out.print(s + " ");
        System.out.println();
    }
    

    public static void main(String[] args) {
        UndoRedo app = new UndoRedo();
        Scanner scanner = new Scanner(System.in);
        String command;
        
        while (true) {
            System.out.println("---------------------------------");
            System.out.println("Ketikkan teks sebagai command.");
            System.out.println("Ketik U untuk melakukan Undo");
            System.out.println("Ketik R untuk melakukan Redo");
            System.out.println("Ketik X untuk mengakhiri program.");
            System.out.print("Command: ");
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("x")) break;
            if (command.equalsIgnoreCase("u")) { app.undo(); }
            else if (command.equalsIgnoreCase("r")) { app.redo(); }
            else app.action(command);
        }

        scanner.close();
        System.out.println("Program selesai.");

    }
}