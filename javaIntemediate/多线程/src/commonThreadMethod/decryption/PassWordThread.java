package commonThreadMethod.decryption;

import java.util.List;

public class PassWordThread extends Thread {
    private String password;
    private List<String> passwords;
    private boolean found = false;


    public PassWordThread(String password, List<String> passwords) {
        this.password = password;
        this.passwords = passwords;
    }

    @Override
    public void run() {
        char[] guessPassword = new char[password.length()];
        generatePassword(guessPassword, password);
    }

    private void generatePassword(char[] guessPassword, String password) {
        generatePasswordRecursive(guessPassword, 0, password);
    }

    private void generatePasswordRecursive(char[] guessPassword, int index, String password) {
        if (found) {
            return;
        }

        for (short i = '0'; i <= 'z'; i++) {
            char c = (char) i;
            if (!Character.isLetterOrDigit(c)) {
                continue;
            }
            guessPassword[index] = c;
            if (index != guessPassword.length - 1) {
                generatePasswordRecursive(guessPassword, index + 1, password);
            } else {
                String guess = String.valueOf(guessPassword);
                passwords.add(guess);
                if (guess.equals(password)) {
                    System.out.println("密码找到了为！！！！！！" + password);
                    found = true;
                    return;
                }
            }
        }
    }
}
