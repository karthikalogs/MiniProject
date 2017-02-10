import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

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
