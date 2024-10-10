package reservasihotel;

public class Kamar {
    private String nomorKamar;
    private double harga;
    private boolean tersedia;

    public Kamar(String nomorKamar, double harga) {
        this.nomorKamar = nomorKamar;
        this.harga = harga;
        this.tersedia = true;  // Kamar defaultnya tersedia
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public double getHarga() {
        return harga;
    }

    public boolean tersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    @Override
    public String toString() {
        return "Tipe: " + nomorKamar + ", Harga: Rp " + harga + ", Tersedia: " + (tersedia ? "Ya" : "Tidak");
    }
}
