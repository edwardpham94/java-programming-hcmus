package Thread;

class MyThread12 implements Runnable{
    Thread thrd;
    MyThread12(String name){ thrd = new Thread(this, name); }
    public static MyThread12 createAndStart(String name) {
        MyThread12 myThrd = new MyThread12(name);
        myThrd.thrd.start(); // start the thread
        return myThrd;
    }
    @Override
    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            for(int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + thrd.getName() +
                        ", count is " + count);
            }
        }catch(InterruptedException exc) {
            System.out.println(thrd.getName() + " interrupted.");
        }
        System.out.println(thrd.getName() + " terminating.");
    }
}