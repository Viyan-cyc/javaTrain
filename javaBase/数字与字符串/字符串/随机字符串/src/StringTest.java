public class StringTest {
    /**
     * 创建一个长度是5的随机字符串，随机字符有可能是数字，大写字母或者小写字母
     */
    public void randomString() {
        // 方法一
        char[] cs = new char[5];
        short start = '0';
        short end = 'z' + 1;
        for (int i = 0; i < cs.length; i++) {
            while (true) {
                char c =(char) (Math.random() * (end - start) + start);
                if (Character.isLetter(c) || Character.isDigit(c)) {
                    cs[i] = c;
                    break;
                }
            }
        }
        System.out.println(String.valueOf(cs));

        // 方法二
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        char[] cs2 = new char[5];
        for (int i = 0; i < cs2.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs2[i] = pool.charAt(index);
        }
        System.out.println(String.valueOf(cs2));
    }

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.randomString();
    }
}
