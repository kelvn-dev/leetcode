import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Temp {
    public static void main(String[] args) {

    }

    public void myPow(double x, int n) {
        synchronized (this) {
            // only 1 thread at a time
        }

        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            // task
        } finally {
            lock.unlock();
        }
    }
}
