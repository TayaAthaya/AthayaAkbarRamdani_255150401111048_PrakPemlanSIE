import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Mobil m1 = new Mobil();

        System.out.print("Masukkan merk mobil: ");
        String merk = in.nextLine();

        System.out.print("Masukkan nomor polisi: ");
        String nopol = in.nextLine();

        m1.setMerk(merk);
        m1.setNopol(nopol);
        m1.setWarna("Merah");
        m1.setKecepatan(50);

        m1.display();

        m1.hitungJarak(2);
        m1.tampilKecepatanMS();
    }
}