
class Pengguna {
    private String namaPengguna;
    private String kataSandi;

    public Pengguna(String namaPengguna, String kataSandi) {
        this.namaPengguna = namaPengguna;
        this.kataSandi = kataSandi;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public String getKataSandi() {
        return kataSandi;
    }
}