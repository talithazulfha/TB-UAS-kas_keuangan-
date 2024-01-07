public class Transaksi {
    private String deskripsi;
    private double jumlah;

    public Transaksi(String deskripsi, double jumlah) {
        this.deskripsi = deskripsi;
        this.jumlah = jumlah;
    }

    public void eksekusi(Akun akun) {
        // Implementasi operasi transaksi pada akun
        // Contoh: Menambahkan jumlah transaksi ke saldo akun
        akun.setSaldo(akun.getSaldo() + jumlah);
        System.out.println("Transaksi berhasil: " + deskripsi + " sejumlah " + jumlah);
        System.out.println("Saldo akun " + akun.getNamaAkun() + " saat ini: " + akun.getSaldo());
    }

    public String getDeskripsi() {
        return null;
    }

    public String getJumlah() {
        return null;
    }

    public String getTimestamp() {
        return null;
    }
}
