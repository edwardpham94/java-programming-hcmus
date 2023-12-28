package Thread;

class JoinThreads {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");
        MyThread3 mt1 = new MyThread3("Child #1");
        MyThread3 mt2 = new MyThread3("Child #2");
        MyThread3 mt3 = new MyThread3("Child #3");
        try {
            mt1.thrd.join();
            System.out.println("Child #1 joined.");
            mt2.thrd.join();
            System.out.println("Child #2 joined.");
            mt3.thrd.join();
            System.out.println("Child #3 joined.");
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread ending.");
    }
}