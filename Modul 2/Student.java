public class Student {
    private String nama;
    private int skor;

    public Student(String nama) {
        this.nama = nama;
    }

    private void setNama(String nama) {
        this.nama = nama;
    }

    public static void ubahNama(Student std, String nama) {
        std.nama = nama;
    }

    public int getSkor() {
        return this.skor;
    }

    public String getNama() {
        return this.nama;
    }

    public static void setSkor(Student std, int skor) {
        std.skor = skor;
    }
}
