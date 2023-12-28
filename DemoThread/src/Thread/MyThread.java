package Thread;

class MyThread implements Runnable {
    String thrdName;
    Thread thrd;
    MyThread(String name) {
        thrdName = name;
        thrd = new Thread(this, name); thrd.start();
    }

    // Entry point of thread.
    public void run() {
        System.out.println(thrdName + " starting.");
        for (int count = 0; count < 10; count++) {
            System.out.println("In " + thrdName +
                    ", count is " + count);
        }
        System.out.println(thrdName + " terminating.");
    }

    public static void main(String args[]) {
        System.out.println("Main thread starting.");

        MyThread mt1 = new MyThread("Child #1");
        MyThread mt2 = new MyThread("Child #2");
        MyThread mt3 = new MyThread("Child #3");

        for (int i = 0; i < 30; i++) {
            System.out.print(".");
        }
        System.out.println("Main thread ending.");
    }
}