package reservasihotel;

import java.util.List;

public class Customer implements User {
    private String namaCustomer;

    public Customer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public void lihatKamar(List<Kamar> kamarList) {
        System.out.println("Customer " + namaCustomer + " melihat kamar yang tersedia:");
        for (Kamar kamar : kamarList) {
            System.out.println(kamar);
        }
    }

    public void pesanKamar(Kamar kamar, int durasiMenginap, Admin admin) {
        if (kamar.tersedia()) {
            System.out.println("Booking kamar " + kamar.getNomorKamar() + " untuk " + namaCustomer + " selama " + durasiMenginap + " malam.");
            Booking booking = new Booking(kamar, namaCustomer, durasiMenginap);
            kamar.setTersedia(false);

            admin.perlihatkanTotalBayar(booking);
        } else {
            System.out.println("Kamar " + kamar.getNomorKamar() + " tidak tersedia.");
        }
    }
}
