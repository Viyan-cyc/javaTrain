package interaction.step9;

public class TestThread {

    public static void main(String[] args) {
        MyStack<Character> myStack = new MyStack<>();
        ProducerThread p1 = new ProducerThread(myStack, "p1");
        ProducerThread p2 = new ProducerThread(myStack, "p2");
        ConsumerThread c1 = new ConsumerThread(myStack, "c1");
        ConsumerThread c2 = new ConsumerThread(myStack, "c2");
        ConsumerThread c3 = new ConsumerThread(myStack, "c3");
        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
