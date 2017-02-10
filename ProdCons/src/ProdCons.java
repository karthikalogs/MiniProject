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





