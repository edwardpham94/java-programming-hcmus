package Thread;

class MoreThreads {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");

        MyThread2 mt1 = new MyThread2("Child #1");
        MyThread2 mt2 = new MyThread2("Child #2");
        MyThread2 mt3 = new MyThread2("Child #3");
        for (int i = 0; i < 30; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
    }
}