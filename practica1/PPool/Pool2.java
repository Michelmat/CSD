
public class Pool2 extends Pool{ //max 2 kids/instructor
    int cap = 0; int ki = 0; int maxkid= 0; 
    public void init(int ki, int cap)  {maxkid = ki;}
    
    //     public synchronized void kidSwims()  throws InterruptedException     {log.swimming();}
    //     
    //     public synchronized void kidRests()      {log.resting(); }
    //     
    //     public synchronized void instructorSwims()   {log.swimming();}
    //     
    //     public synchronized void instructorRests() throws InterruptedException   {log.resting(); }
    //     
  public synchronized void kidSwims()throws InterruptedException {
        
        while(cap == 0 || ki+1 > (2*cap) ) {
            
            log.waitingToSwim();
            wait();
        }
        ki++;
        log.swimming();
        notify();
        
    }

    public synchronized void kidRests() {
        ki--;
        notify();
        log.resting();
    }

    public synchronized void instructorSwims() throws InterruptedException{
            while (cap+ki > 4){
            log.waitingToSwim();
            wait();
        }
        log.swimming();
        cap++;
        notify();
        log.swimming();
    }

    public synchronized void instructorRests() throws InterruptedException{
        while (ki!=0 || ki > (2*cap-1) ){
           
            log.waitingToRest();
            wait();
        }
        cap--;
        notify();
        log.resting();
    }

}
 
