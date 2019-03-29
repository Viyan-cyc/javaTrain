package interaction.step9;

public class ProducerThread extends Thread{

    private MyStack<Character> myStack;

    public ProducerThread(MyStack myStack, String name) {
        super(name);
        this.myStack = myStack;
    }

    @Override
    public void run() {
        while (true) {
            char c  = randomCharacter();
            System.out.println(this.getName() + "压入" + c);
            myStack.push(c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static char randomCharacter() {
        char word;
        word = (char) (Math.random() * ('Z' + 1 - 'A') + 'A');
        return word;
    }
}
