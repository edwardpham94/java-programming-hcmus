package Thread;

class ThreadCom {
    public static void main(String args[]) {
        TickTock tt = new TickTock();
        MyThread6 mt1 = new MyThread6("Tick", tt);
        MyThread6 mt2 = new MyThread6("Tock", tt);
        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
    }
}
