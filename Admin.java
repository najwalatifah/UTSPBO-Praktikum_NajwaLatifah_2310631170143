package reservasihotel;

import java.util.List;

public class Admin implements User {
    private String namaAdmin;

    public Admin(String namaAdmin) {
        this.namaAdmin = namaAdmin;
    }

    public void lihatKamar(List<Kamar> kamarList) {
        System.out.println("Admin " + namaAdmin + " menunjukkan kamar yang tersedia: ");
        for (Kamar kamar : kamarList) {
            System.out.println(kamar);
        }
    }

    public void perlihatkanTotalBayar(Booking booking) {
        if (booking != null) {
            System.out.println("Total yang harus dibayar: Rp " + booking.getTotalJumlah());
        } else {
            System.out.println("Pemesanan tidak ditemukan.");
        }
    }
}
