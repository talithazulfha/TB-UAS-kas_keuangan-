import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

class AplikasiManajemenKeuangan {
    private PenggunaKas penggunaKas;
    private Akun akunKas;
    private Connection connection;

    public AplikasiManajemenKeuangan(String namaPengguna, String kataSandi) throws SQLException {
    penggunaKas = new PenggunaKas(namaPengguna, kataSandi);
    akunKas = new Akun(kataSandi, 0);

    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financial", "root", "");
    
    }

    private void tampilkanTransaksi() {
        List<Transaksi> transactions = akunKas.getTransactions();
        if (transactions.isEmpty()) {
            System.out.println("Tidak ada transaksi yang tersedia.");
        } else {
            System.out.println("\nTransaksi Akun Kas:");
            for (Transaksi transaction : transactions) {
                System.out.println(transaction.getDeskripsi() + ": Rp" + transaction.getJumlah() + " pada " + transaction.getTimestamp());
            }
        }
    }

    public void jalankan() {
        Scanner scanner = new Scanner(System.in);
        boolean keluar = false;

        while (!keluar) {
            System.out.println("\nAplikasi Manajemen Keuangan");
            System.out.println("1. Deposit");
            System.out.println("2. Tarik");
            System.out.println("3. Cek Saldo");
            System.out.println("4. Keluar");

            System.out.print("Masukkan pilihan Anda: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jumlah deposit: Rp");
                    double jumlahDeposit = scanner.nextDouble();
                    penggunaKas.deposit(jumlahDeposit);
                    break;
                case 2:
                    System.out.print("Masukkan jumlah penarikan: Rp");
                    double jumlahPenarikan = scanner.nextDouble();
                    penggunaKas.tarik(jumlahPenarikan);
                    break;
                case 3:
                    double saldo = penggunaKas.cekSaldo();
                    System.out.println("Saldo saat ini: Rp" + saldo);
                    break;
                case 4:
                    keluar = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        // Tutup sumber daya
        scanner.close();
    }

}