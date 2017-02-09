import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdCons {

    public static void main(String args[]){
  
    
     //Creating shared object
     BlockingQueue sharedQue = new LinkedBlockingQueue();
      //Creating Producer and Consumer Thread
     Thread prodThread = new Thread(new Prod(sharedQue));
     Thread consThread = new Thread(new Cons(sharedQue));
     //Starting producer and Consumer thread
     prodThread.start();
     consThread.start();
    }
}

//Producer Class in java
class Prod implements Runnable {

    private final BlockingQueue sharedQueue;
    Scanner scanner = new Scanner(System.in);
    int a = 0;
    public Prod(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
            	System.out.println("Enter an input parameter : ");
                a = scanner.nextInt(); 
                if(a != 0)
                {
                	sharedQueue.put(a);
                   
                }
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Prod.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

//Consumer Class in Java
class Cons implements Runnable{

    private final BlockingQueue shareQue;
    public Cons (BlockingQueue shareQue) {
        this.shareQue = shareQue;
    }
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ shareQue.take());
                Thread.sleep(30000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cons.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
  
  
}

