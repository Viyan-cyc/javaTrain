package lock.step7;

import synchronizedTest.step1.Hero;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyStack {
        LinkedList<Hero> heroes = new LinkedList<>();

        Lock lock = new ReentrantLock();

        public void push(Hero h) {
            try {
                lock.lock();
                heroes.addLast(h);
            } finally {
                lock.unlock();
            }
        }

        public Hero pull() {
            try {
                lock.lock();
                return heroes.removeLast();
            } finally {
                lock.unlock();
            }
        }

        public Hero peek() {
            return heroes.getLast();
        }
}
