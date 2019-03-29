package commonThreadMethod.decryption;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String password = randomPassword(3);
        System.out.println("密码为" + password);
        List<String> passwords = new ArrayList<>();

        new PassWordThread(password, passwords).start();

        new LogThread(passwords).start();
    }

    private static String randomPassword(int len) {
        StringBuilder stringBuilder = new StringBuilder(len);
        short start = '0';
        short end = 'z' + 1;
        for (int i = 0; i < len; i++) {
            char randomChar = ' ';
            while (!Character.isLetterOrDigit(randomChar)) {
                randomChar = (char) (Math.random() * (end - start) + start);
            }
            if (Character.isLetterOrDigit(randomChar)) {
                stringBuilder.append(randomChar);
            }
        }
        return stringBuilder.toString();
    }
}
