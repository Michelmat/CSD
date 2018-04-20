import java.io.*;
import java.util.*;
/**
 * Write a description of class UsoDeArrayList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UsoDeArrayList {
   
   public static void main (String args[]) throws FileNotFoundException {
       File fd = new File("fichero.txt");
       Scanner fichero = new Scanner(fd);
       ArrayList<String> lista = new ArrayList<String>();
       String s;
       while(fichero.hasNextLine()){
        s = fichero.nextLine();
        lista.add(s);
      
        }
       Collections.sort(lista);
       
       System.out.println(lista);
      
    }
    

}
