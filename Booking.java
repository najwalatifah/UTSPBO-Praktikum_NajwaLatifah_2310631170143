package reservasihotel;

public class Booking {
    private double totalJumlah;
    
    public Booking(Kamar kamar, String namaCustomer, int durasiMenginap) {
        this.totalJumlah = kamar.getHarga() * durasiMenginap;
        System.out.println("Kamar ini dipesan atas nama " + namaCustomer + " di kamar " + kamar.getNomorKamar() + " untuk " + durasiMenginap + " malam.");
    }
    
    public double getTotalJumlah() {
        return totalJumlah;
    }
}
