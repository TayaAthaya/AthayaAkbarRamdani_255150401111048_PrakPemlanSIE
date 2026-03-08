public class Mobil {
    private String nopol;
    private String warna;
    private String merk;
    private int kecepatan;
    private double jarakTempuh;

    public void setNopol(String n) {
        nopol = n;
    }
    public void setWarna(String s) {
        warna = s;
    }
    public void setMerk(String m) {
        merk = m;
    }
    public void setKecepatan(int k) {
        kecepatan = k;
    }

    public void hitungJarak(int waktu) {
        jarakTempuh = kecepatan * waktu;
        System.out.println("Jarak tempuh mobil adalah " + jarakTempuh + " km");
    }

    public void tampilKecepatanMS() {
        double ms = kecepatan * 1000 / 3600.0;
        System.out.println("Kecepatan dalam m/s = " + ms);
    }

    public void display() {
        System.out.println("Mobil bermerk " + merk);
        System.out.println("bernomor polisi " + nopol);
        System.out.println("serta memililki warna " + warna);
        System.out.println("bergerak dengan kecepatan " + kecepatan + " kpj");
    }
}