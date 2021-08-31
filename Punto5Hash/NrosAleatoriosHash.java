import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

public class NrosAleatoriosHash {
    static int tope = 1000;
    public static void main(String[] args) {
        double tiempoInicial = System.nanoTime();
        Random generador = new Random();
        int min=1;
        Hashtable<Integer, Integer> hash = new Hashtable<>();
        int contNum = 0;
        int contErrores = 0;
        try{
            BufferedWriter buff = new BufferedWriter(new FileWriter("./numerosUnicos.txt"));
            while(contNum < tope){
                int num = generador.nextInt(tope)+min;
                //int num = (int) (Math.random()*tope);
                if(hash.get(num)==null) {
                    buff.write(num +"\n");
                    hash.put(num, num);
                    contNum++;
                }else{
                    contErrores++;
                }
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
            System.out.println("Errores: "+contErrores);
        }
    }

}