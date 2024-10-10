package reservasihotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin");
        List<Kamar> kamarList = new ArrayList<>();
        // Menggunakan tipe kamar yang sesuai
        kamarList.add(new Kamar("TipeKamar sendiri", 2000000.0));
        kamarList.add(new Kamar("TipeKamar pasangan", 2500000.0));
        kamarList.add(new Kamar("TipeKamar keluarga", 3000000.0));

        System.out.println("Masukkan status anda (admin/customer): ");
        String role = scanner.nextLine();

        User user;
        if (role.equalsIgnoreCase("admin")) {
            user = admin;
        } else {
            System.out.println("Masukkan nama Anda: ");
            String namaCustomer = scanner.nextLine();
            user = new Customer(namaCustomer);
        }

        if (user instanceof Customer) {
            Customer customer = (Customer) user;
            customer.lihatKamar(kamarList);

            System.out.println("Apakah anda ingin memesan kamar? (ya/tidak): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("ya")) {
                System.out.println("Masukkan tipe kamar yang ingin dipesan (sendiri/pasangan/keluarga): ");
                String tipeKamar = scanner.nextLine();

                Kamar kamarUntukDipesan = null;
                for (Kamar kamar : kamarList) {
                    if (kamar.getNomorKamar().equalsIgnoreCase("TipeKamar " + tipeKamar)) {
                        kamarUntukDipesan = kamar;
                        break;
                    }
                }

                // Jika kamar ditemukan, lakukan pemesanan
                if (kamarUntukDipesan != null) {
                    System.out.println("Masukkan durasi menginap (malam): ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Input tidak valid. Masukkan durasi menginap (malam): ");
                        scanner.next();
                    }
                    int durasiMenginap = scanner.nextInt();

                    // Validasi durasi menginap
                    if (durasiMenginap <= 0) {
                        System.out.println("Durasi menginap harus lebih dari 0 malam.");
                    } else {
                        customer.pesanKamar(kamarUntukDipesan, durasiMenginap, admin);
                    }
                } else {
                    System.out.println("Tipe kamar tidak ditemukan.");
                }
            }
        } else {
            admin.lihatKamar(kamarList); // Menampilkan kamar untuk admin
        }

        scanner.close();
    }
}
