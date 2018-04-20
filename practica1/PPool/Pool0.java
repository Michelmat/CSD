// CSD feb 2015 Juansa Sendra

public class Pool0 extends Pool {	//free access
    public void init(int ki, int cap) 			{}
    public void kidSwims() 		{log.swimming();}
    public void kidRests() 		{log.resting(); }
    public void instructorSwims()	{log.swimming();}
    public void instructorRests() 	{log.resting(); }
}


// public class Pool0 extends Pool {	//free access
// 	Log log;
// 	public void make(Log log0) 			{log=log0;}
// 	protected void await() {
// 		try{wait();} catch(Exception e) {}
// 	}
//     public  long begin(int id)			{return log.begin(id);}
//     public  void end(int id)	{log.end(id);}
//     	
// 	
// 	public long kidSwims(int id) {
// 		return log.swims(id);
// 	}
// 	
// 	public long kidRests(int id) {
// 		return log.rests(id);
// 	}
// 	
// 	public long instructorSwims(int id) {
// 		return log.swims(id);
// 	}
// 	
// 	public long instructorRests(int id) {
// 		return log.rests(id);
// 	}
// 	
// }
