
/**
 * Write a description of class Rectangulo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangulo extends Figura{
    private double base, altura;
   public Rectangulo(double x, double y, double base, double altura){
       this.x = x;
       this.y = y;
       this.base = base;
       this.altura = altura;
    }
   
   public String toString ()
   {return "Rectangulo:\n\t"+
       super.toString()+
            "\n\tBase: "+base+
            "\n\tAltura: "+altura;
    }
   public double Area (){
       return base * altura / 2;
    }    
       
   public boolean equals(Object o){
      if(o instanceof Rectangulo){
        return this.x == ((Rectangulo)o).x
               &&this.y == ((Rectangulo)o).y
               &&this.base == ((Rectangulo)o).base
               &&this.altura == ((Rectangulo)o).altura;
        }else{
            return false;
        } 
      
     }
   public double volumen(){
       return 0;
    }
}
