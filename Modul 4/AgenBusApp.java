public class AgenBusApp {
    public static void main(String[] args) {
        Tiket t1 = new Tiket();
        t1.pesan();
        t1.tampil();

        TiketBus t2 = new TiketBus();
        t2.pesan();
        t2.tampil();
        
        TiketBus t3 = new TiketBus();
        t3.pesan("Kasino", "Bandung", 650, 450000);
        t3.tampil();
        
        t1.pesan("Indro", "Makassar");
        t1.tampil();
        t2.pesan("Dono", "Makassar");
        t2.tampil();

        TiketBus tb = new TiketBus();
        tb.pesan("Budi");
        tb.tampil();

        TiketBus t4 = new TiketBus() {
        @Override
            public void tampil() {
                System.out.println("====================================");
                System.out.println("           TIKET BUS EKSPRES        ");
                System.out.println("====================================");
                System.out.println(" Penumpang  : " + namaPenumpang);
                System.out.println(" Tujuan     : " + tujuan);
                System.out.println(" Harga      : Rp " + (long)hargaTiket);
                System.out.println("====================================");
        }
        };
        t4.pesan("Budi", "Yogyakarta", 300, 150000);
        t4.tampil();
    }
}
