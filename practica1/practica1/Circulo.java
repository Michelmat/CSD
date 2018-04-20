
/**
 * Write a description of class Circulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circulo extends Figura{
   protected double r;
   public Circulo(double x, double y, double radio){
       super.x = x;
       this.y = y;
       r = radio;
    }
   
   public String toString ()
   {return "Circulo:\n\t"+
       super.toString()+"\n\tRadio: "+r;
    }
   public double Area (){
       return Math.pow(r,2)*Math.PI;
    }    
       
   public boolean equals(Object o){
      if(o instanceof Circulo){
        return this.x == ((Circulo)o).x
               &&this.y == ((Circulo)o).y
               &&this.r == ((Circulo)o).r;
        }else{
            return false;
        } 
      
     }
   public double volumen(){
       return 0;
    }
}
