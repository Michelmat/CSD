public class Pool1 extends Pool{//there cannot be kids alone
    int cap = 0, ki = 0;
    public void init(int ki, int cap){
//             this.ki = ki; 
//             this.cap = cap;
        }
    public synchronized void kidSwims()throws InterruptedException {
        while(cap < 1) {
            log.waitingToSwim();
            wait();
        }
        ki++;
        notify();
        log.swimming();
    }

    public synchronized void kidRests() {
        ki--;
        notify();
        log.resting();
    }

    public synchronized void instructorSwims() {
        cap++;
        notify();
        log.swimming();
    }

    public synchronized void instructorRests() throws InterruptedException{
        while (cap == 1 && ki > 0) {
            log.waitingToRest();
            wait();
        }
        cap--;
        notify();
        log.resting();
    }


}
