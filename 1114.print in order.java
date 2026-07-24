import java.util.concurrent.atomic.AtomicInteger;

class Foo {
    private AtomicInteger step = new AtomicInteger(0);

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        step.set(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (step.get() < 1) {
            // Busy wait / spin
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        step.set(2);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (step.get() < 2) {
            // Busy wait / spin
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
