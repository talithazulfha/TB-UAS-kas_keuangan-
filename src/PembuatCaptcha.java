import java.util.Random;

public class PembuatCaptcha {
    private static final String KARAKTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int PANJANG_CAPTCHA = 6;

    public String hasilkanCaptcha() {
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < PANJANG_CAPTCHA; i++) {
            int index = random.nextInt(KARAKTER.length());
            captcha.append(KARAKTER.charAt(index));
        }

        return captcha.toString();
    }
}