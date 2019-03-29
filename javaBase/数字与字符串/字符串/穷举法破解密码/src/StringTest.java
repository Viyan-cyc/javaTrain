public class StringTest {
    private static boolean found = false;
    public static void main(String[] args) {

        // 多层循环
        multiCycle();

        // 递归
        recursive();

    }

    // 多层循环
    public static void multiCycle() {
        String password = randomString(3);
        System.out.println("密码是" + password);
        char[] guassPassword = new char[3];
        boolean find = false;
        while (!find) {
            for (short i = '0'; i <= 'z'; i++) {
                for (short j = '0'; j < 'z'; j++) {
                    for (short k = '0'; k < 'z'; k++) {
                        if (!isLetterOrDigit(i, j, k)) {
                            continue;
                        }
                        guassPassword[0] = (char) i;
                        guassPassword[1] = (char) j;
                        guassPassword[2] = (char) k;
                        String guess = String.valueOf(guassPassword);
                        if (guess.equals(password)) {
                            System.out.printf("匹配成功%s%n", guess);
                            find = true;
                        }
                    }
                }
            }
        }
    }

    public static void recursive() {
        String password = randomString(3);
        System.out.println("密码为" + password);
        char[] guessPassword = new char[3];
        recursiveInternally(guessPassword, 0, password);
    }

    public static void recursiveInternally(char[] guessPassword, int index, String password) {
        if (found) {
            return;
        }
        for (short i = '0'; i <= 'z'; i++) {
            char c = (char) i;
            if (!Character.isLetterOrDigit(c)) {
                continue;
            }
            guessPassword[index] = c;
            if (guessPassword.length - 1 != index) {
                recursiveInternally(guessPassword, index + 1, password);
            } else {
                String guess = String.valueOf(guessPassword);
                if (guess.equals(password)) {
                    System.out.println("完成，密码为" + guess);
                    found = true;
                    return;
                }
            }
        }
    }

    private static boolean isLetterOrDigit(short i, short j, short k) {
        return Character.isLetterOrDigit(i) &&
                Character.isLetterOrDigit(j) &&
                Character.isLetterOrDigit(k);
    }


    public static String randomString(int len) {
        char[] cs = new char[len];
        short start = '0';
        short end = 'z' + 1;
        for (int i = 0; i < cs.length; i++) {
            while (true) {
                char c = (char) (Math.random() * (end - start) + start);
                if (Character.isLetter(c) || Character.isDigit(c)) {
                    cs[i] = c;
                    break;
                }
            }
        }
        return String.valueOf(cs);
    }
}
