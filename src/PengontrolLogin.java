public class PengontrolLogin {
    String captchaTersimpan;

    public PengontrolLogin() {
        PembuatCaptcha pembuatCaptcha = new PembuatCaptcha();
        captchaTersimpan = pembuatCaptcha.hasilkanCaptcha();
    }

    public boolean validasiCaptcha(String inputPengguna) {
        return inputPengguna.equalsIgnoreCase(captchaTersimpan);
    }

    public boolean autentikasiPengguna(String namaPengguna, String kataSandi) {

        return true;
    }
}