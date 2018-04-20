
/**
 * Write a description of class GrupoFiguras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrupoFiguras{
    static final int MAX_NUM_FIGURAS = 10;
    private Figura [] listaFiguras = new Figura [MAX_NUM_FIGURAS];
    private int numF = 0;
    public void anyadeFigura(Figura f){
        listaFiguras[numF++]=f;
    }
    public String toString(){
        String s= "";
       for(int i = 0;i < numF; i++){
           s+="\n"+listaFiguras[i];
           
        }
       return s;
    }
    public boolean compara(Object [] lista1,Object [] lista2){
        boolean comp=true;
        for(int i=0;i<lista1.length;i++){
            if(lista1[i] instanceof Circulo){
                for(int j=0;j<lista2.length;j++){
                    if(!lista1[i].equals(lista2[j]))comp=false;
                }
            }
            if(lista1[i] instanceof Triangulo){
                for(int j=0;j<lista2.length;j++){
                    if(!lista1[i].equals(lista2[j]))comp=false;
                }
            }
            if(lista1[i] instanceof Rectangulo){
                for(int j=0;j<lista2.length;j++){
                    if(!lista1[i].equals(lista2[j]))comp=false;
                }
            }
        }
        return comp;
    }
    public boolean equals(Object [] lista){
        compara(lista,this.listaFiguras);
        compara(this.listaFiguras,lista);
        return true;
    }
    public double Area(){
        double aux = 0;
        for(int i = 0;i<numF-1;i++){
            aux += listaFiguras[i].Area();
        }
        return aux;
    }
    public double volumen(){
        double aux = 0;
        for(int i = 0;i<numF-1;i++){
            if(listaFiguras[i] instanceof Volumen){
                aux += listaFiguras[i].volumen();
            }
        }
        return aux;
    }
}
