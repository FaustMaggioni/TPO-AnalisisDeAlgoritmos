import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class NrosAleatoriosArr {
    static int cantNros = 1000;
    public static void main(String[] args) {
        double tiempoInicial = System.nanoTime();
        int[] nros = crearLista(cantNros);
        try{
            BufferedWriter buff = new BufferedWriter(new FileWriter("./numerosUnicos.txt"));
            for(int i=1; i<=cantNros;i++) {
                int nuevoNro = getUnNumero(nros, cantNros);
                buff.write(nuevoNro + "\n");
            }
            buff.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }finally {
            double tiempoFinal = System.nanoTime();
            double tiempoTotal = tiempoFinal-tiempoInicial;
            System.out.println("Tiempo: "+tiempoTotal+"ns");
        }
    }

    public static int[] crearLista(int cantNros){
        int[] nros = new int[cantNros];
        for(int i=1;i<cantNros;i++){
            nros[i]=0;
        }
        return nros;
    }

    public static int getUnNumero(int[] nros, int tope){
        Random generator = new Random();
        boolean ok = false;
        int res = -1;
        while(!ok){
            res = generator.nextInt(tope)+1;
            int nro = nros[res-1];
            if(nro!=-1){
                nros[res-1]=-1;
                ok = true;
            }
        }
        return res;
    }
}