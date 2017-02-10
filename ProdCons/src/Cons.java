import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

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
