
/**
 * Write a description of class Figuras here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Figura {
       protected double x, y; //Posicion de la figura
       public String toString(){
            return "Posicion: ("+x+", "+y+")";
        }
       public abstract double Area();
       public abstract double volumen();
}
