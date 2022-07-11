package Programming_Practice;

public class ThreadPractice {
    public static void main(String[] args) {
        NewThread t = new NewThread();
        t.run();
    }
}

class NewThread extends Thread{
    public void run(){
        long startTime = System.currentTimeMillis();
        int i=0;
        while(i<=10){
            System.out.println("THREAD NAME "+ Thread.currentThread().getName());
            System.out.println(" New Thread is coming " +i++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //i++;
        }
    }
}

// NOTE : - To get production ready codes we need to write code to maintain few things
//          1. The consistent creation of new threads
//          2. The no of concurrent live threads
//          3. The threads deallocation  - very imp for deamon threads for memory deallocation

// THE EXECUTOR SERVICE FRAMEWORK - It implements the thread pool design pattern also called as
// worker or work-crew model and takes care of the thread management.

// Thread reusability is super important





