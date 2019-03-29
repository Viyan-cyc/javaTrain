package interaction.step9;

public class ConsumerThread extends Thread {
    private MyStack myStack;

    public ConsumerThread(MyStack myStack, String name) {
        super(name);
        this.myStack = myStack;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.getName() + "弹出" + myStack.pull());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
