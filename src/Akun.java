import java.util.List;

public class Akun {
    private String namaAkun;
    private double saldo;

    public Akun(String namaAkun, double saldoAwal) {
        this.namaAkun = namaAkun;
        this.saldo = saldoAwal;
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void tambahTransaksi(Transaksi transaksi) {
        transaksi.eksekusi(this);
    }

    public List<Transaksi> getTransactions() {
        return null;
    }
}

