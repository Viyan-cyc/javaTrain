package commonThreadMethod.decryption;

import java.util.List;

public class LogThread extends Thread {
    private boolean found = false;
    private List<String> passwords;

    public LogThread(List<String> passwords) {
        this.passwords = passwords;
        // 守护线程，当passwordthread结束时，main中只剩下守护线程，就会结束了
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (!found) {
            while (passwords.isEmpty()) {
                try {
                    System.out.println("sleep");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String password = passwords.remove(0);
            System.out.println("本次穷举为：" + password);
        }
    }
}
