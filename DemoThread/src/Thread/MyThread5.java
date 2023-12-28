package Thread;

class MyThread5 implements Runnable {
    Thread thrd;
    static SumArray sa = new SumArray();
    int a[]; int answer;
    MyThread5(String name, int nums[]) {
        thrd = new Thread(this, name);
        a = nums; thrd.start(); // start the thread
    }
    public void run() {
        int sum;
        System.out.println(thrd.getName() + " starting.");
// synchronize calls to sumArray()
        synchronized (sa) { answer = sa.sumArray(a); }
        System.out.println("Sum for " + thrd.getName()
                + " is " + answer);
        System.out.println(thrd.getName() + " terminating.");
    }
}
