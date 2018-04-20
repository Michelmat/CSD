
/**
 * Write a description of class Triangulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Triangulo extends Figura{
    private double base,altura;
    public Triangulo(double x,double y,
    double base, double altura){
        this.x= x;
        this.y = y;
        this.base = base;
        this.altura = altura;
    }
    public String toString()
        {return "Triangulo:\n\t"+
            super.toString()+
            "\n\tBase: "+base+
            "\n\tAltura: "+altura;
        }   
    public boolean equals(Object o){
      if(o instanceof Triangulo){
        return this.x == ((Triangulo)o).x
               &&this.y == ((Triangulo)o).y
               &&this.base == ((Triangulo)o).base
               &&this.altura == ((Triangulo)o).altura;
        }else{
            return false;
        }       
    }
    public double Area (){
        return base * altura / 2;
    }
    public double volumen(){
       return 0;
    }
}
