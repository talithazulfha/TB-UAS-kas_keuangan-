import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

class PenggunaKas extends Pengguna implements OperasiKas {
    private double saldo;
    Date date = new Date();
    SimpleDateFormat tanggal = new SimpleDateFormat("'Tanggal Transaksi: 'EEEE',' dd MMMM yyyy");
    SimpleDateFormat jam = new SimpleDateFormat("'Waktu: 'hh:mm:ss a zzz");

    public PenggunaKas(String namaPengguna, String kataSandi) {
        super(namaPengguna, kataSandi);
        this.saldo = 0.0;
    }

    private void simpanTransaksiKeDatabase(String description, double amount) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financial", "root", "")) {
            String insertQuery = "INSERT INTO transactions (username, description, amount, transaction_date) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, getNamaPengguna());
                preparedStatement.setString(2, description);
                preparedStatement.setDouble(3, amount);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposit(double amount) {
        saldo += amount;
        System.out.println("Program Manajemen Keuangan");
        System.out.println("========================================");
        System.out.println("Transaksi oleh: " + getNamaPengguna());
        System.out.println("Deposit sejumlah Rp" + amount + " berhasil.");
        System.out.println(tanggal.format(date));
        System.out.println(jam.format(date));
        System.out.println("Saldo saat ini: Rp" + saldo);

        // Simpan transaksi ke database
        simpanTransaksiKeDatabase("Deposit", amount);
    }

    @Override
    public void tarik(double amount) {
        if (amount <= saldo) {
            saldo -= amount;
            System.out.println("Program Manajemen Keuangan");
            System.out.println("========================================");
            System.out.println("Transaksi oleh: " + getNamaPengguna());
            System.out.println("Penarikan sejumlah Rp" + amount + " berhasil.");
            System.out.println(tanggal.format(date));
            System.out.println(jam.format(date));
            System.out.println("Saldo saat ini: Rp" + saldo);

            // Simpan transaksi ke database
            simpanTransaksiKeDatabase("Penarikan", amount);
        } else {
            System.out.println("Dana tidak mencukupi. Penarikan gagal.");
        }
    }


    @Override
    public double cekSaldo() {
        return saldo;
    }
    
}
