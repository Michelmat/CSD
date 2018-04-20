// CSD feb 2015 Juansa Sendra
public class Pool3 extends Pool{ //max capacity
    int numInstructores = 0;
    int numKids = 0;
    int maxKids = 0;
    int maxCap = 0;
    int Cap = 0;
    public void init(int ki, int cap) {maxKids = ki; maxCap = cap;}

    public synchronized void kidSwims() throws InterruptedException {
        while(( numInstructores <= 0) || (maxKids * (numInstructores -1 ) < numKids || Cap >= maxCap))
        {
            log.waitingToSwim();
            wait();
        }
        //Actualiza estado          (COMPLETAR)
        //Si    necesario,  avisa   del nuevo   estado  a   otros   hilos
        // con  notifyAll();        
        log.swimming();     //para  visualizar  la  posición    del nadador
        numKids++;
        notifyAll();
        Cap++;

    }

    public synchronized void kidRests()      {log.resting(); numKids--; notifyAll(); Cap--;}

    public synchronized void instructorSwims() throws InterruptedException  {
        while(Cap >= maxCap){
            log.waitingToSwim();
            wait();
        }
        notifyAll(); log.swimming(); numInstructores++; Cap++;
    }

    public synchronized void instructorRests() throws InterruptedException   {
        while( (numInstructores == 1 && numKids > 0) || (maxKids * (numInstructores -1) < numKids) ){
            log.waitingToRest();
            wait();
        }

        log.resting();
        numInstructores--;
        notifyAll();
        Cap--;
    }
}