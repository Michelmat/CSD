// CSD Mar 2013 Juansa Sendra

public class LimitedPhilo extends Philo {
    public LimitedPhilo(int id, int cycles, int delay, Table table) {super(id, cycles, delay, table);}

    public void run() {
        table.begin(id);
        try{
            for (int i=0; i<cycles; i++) {

                table.enter(id);
                table.takeL(id);  table.takeR(id);
                table.eat(id); 
                table.dropR(id); table.dropL(id);
                table.exit(id);
                table.ponder(id);

            
            }
            table.end(id);
        }catch (InterruptedException ex) {}
    }
}