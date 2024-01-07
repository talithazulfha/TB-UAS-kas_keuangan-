import java.sql.SQLException;
import java.util.Scanner;

public class Utama {
    public static void main(String[] args) throws SQLException {
        PengontrolLogin pengontrolLogin = new PengontrolLogin();
        Scanner scanner = new Scanner(System.in);

        // Loop verifikasi captcha
        boolean captchaTerverifikasi = false;
        while (!captchaTerverifikasi) {
            System.out.println("Login ke Sistem Manajemen Keuangan");
            System.out.print("Masukkan nama pengguna Anda: ");
            String namaPengguna = scanner.nextLine();
            System.out.print("Masukkan kata sandi Anda: ");
            String kataSandi = scanner.nextLine();

            // Verifikasi captcha
            System.out.println("Captcha: " + pengontrolLogin.captchaTersimpan);
            System.out.print("Masukkan Captcha: ");
            String captchaPengguna = scanner.nextLine();
            captchaTerverifikasi = pengontrolLogin.validasiCaptcha(captchaPengguna);

            if (!captchaTerverifikasi) {
                System.out.println("Captcha tidak benar. Silakan coba lagi.");
            } else {
                // Autentikasi
                boolean hasilAutentikasi = pengontrolLogin.autentikasiPengguna(namaPengguna, kataSandi);
                if (hasilAutentikasi) {
                    // Pengguna terautentikasi, lanjutkan ke aplikasi manajemen keuangan
                    AplikasiManajemenKeuangan aplikasiKeuangan = new AplikasiManajemenKeuangan(namaPengguna, kataSandi);
                    aplikasiKeuangan.jalankan();
                } else {
                    System.out.println("Autentikasi gagal. Harap periksa kredensial Anda dan coba lagi.");
                }
            }

            scanner.close();
        }
    }
}