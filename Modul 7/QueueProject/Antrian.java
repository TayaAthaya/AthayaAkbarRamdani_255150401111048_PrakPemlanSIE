package QueueProject;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Antrian {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>(); // pakai LinkedList agar bisa addFirst
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Menu Antrian Pelanggan:");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Antrian Depan");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Masukan Nama Pelanggan: ");
                        String nama = sc.nextLine(); // ← Soal 1: baris ke-19
                        // Soal 3: Budi masuk paling depan
                        if (nama.equalsIgnoreCase("Budi")) {
                            queue.addFirst(nama);
                        } else {
                            queue.offer(nama);
                        }
                        System.out.println(nama + " ditambahkan ke antrian.");
                        break;
                    case 2:
                        if (queue.isEmpty())
                            System.out.println("Antrian kosong.");
                        else {
                            String dilayani = queue.poll(); // ← Soal 1: baris ke-26
                            System.out.println("Melayani pelanggan : " + dilayani);
                        }
                        break;
                    case 3:
                        System.out.println("Antrian Saat Ini: " + queue);
                        break;
                    case 4:
                        // Soal 2: peek tanpa hapus
                        String depan = queue.peek();
                        if (depan == null) System.out.println("Tidak ada antrian.");
                        else System.out.println("Antrian paling depan: " + depan);
                        break;
                    case 5:
                        System.out.println("Keluar.");
                        sc.close();
                        return;
                    default:
                        throw new Exception("Invalid input.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                sc.next();
            }
        }
    }
}