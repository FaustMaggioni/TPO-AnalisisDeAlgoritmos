import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class NumerosAleatorios {
    static final int MIN_VALOR = -100;
    static final int RANGO = 200;
    static final int CANTNUMEROS = 100;
    static final String NOMBRE_ARCHIVO = "./numeros.txt";

    public static void main(String[] args) {
        try{
            BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
            for (int i = 0; i < CANTNUMEROS ; i++){
                double num = MIN_VALOR + Math.random() * (RANGO);
                buff.write( num +"\n");
            }
            buff.close();
        }
        catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }


}