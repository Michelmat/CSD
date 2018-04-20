
/**
 * Write a description of class Cilindro here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cilindro extends Circulo implements Volumen{
    // instance variables - replace the example below with your own
    protected double a;
    Cilindro(double x, double y, double radio, double altura){

       super(x,y,radio);
       a = altura;
    }

    Cilindro(Circulo c, double altura){

        this(c.x, c.y, c.r, altura);
    }

        public double volumen(){

        return super.Area()*a;
    }
    public double superficie(){    
        double ar = 2*Math.PI*super.r*(a+super.r);
        return ar;
    }
}
