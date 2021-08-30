import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NrosAleatoriosUnicos {
    static int cantNros = 1000;
    public static void main(String[] args) {
        ArrayList nros = crearLista(cantNros);
        try{
            BufferedWriter buff = new BufferedWriter(new FileWriter("./numerosUnicos.txt"));
            for(int i=1; i<=cantNros;i++) {
                int indice = getIndice(nros);
                int nuevoNro = getUnNumero(nros, indice);
                nros.remove(indice);
                buff.write(nuevoNro + "\n");
            }
            buff.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static ArrayList crearLista(int cantNros){
        ArrayList<Integer> nros = new ArrayList<Integer>();
        for(int i=1;i<=cantNros;i++){
            nros.add(i);
        }
        System.out.println(nros.get(0));
        return nros;
    }

    public static int getUnNumero(ArrayList nros, int indice){
        int res = (int) nros.get(indice);
        return res;
    }

    public static int getIndice(ArrayList nros){
        int tope = nros.size();
        System.out.println("Tope: "+tope);
        int indice = (int) (Math.random()*(tope));
        System.out.println("Indice: "+indice);
        return indice;
    }
}