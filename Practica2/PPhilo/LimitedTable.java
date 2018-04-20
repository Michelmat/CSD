// CSD Mar 2013 Juansa Sendra

public class LimitedTable extends RegularTable { //max 4 in dinning-room
    int p =0;    
    public LimitedTable(StateManager state) {super(state);}

    public synchronized void enter(int id) {
        while(p>=4){
            state.wenter(id);
            //wait();

        }
        state.enter(id);
        p++;
    }

    public synchronized void exit(int id)  {
        p--;
        notifyAll();
    }
}