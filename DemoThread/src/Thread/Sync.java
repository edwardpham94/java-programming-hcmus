package Thread;

class Sync {
    public static void main(String args[]) {
        int a[] = { 1, 2, 3, 4, 5 };
        MyThread4 mt1 = new MyThread4("Child #1", a);
        MyThread4 mt2 = new MyThread4("Child #2", a);
        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
    }
}