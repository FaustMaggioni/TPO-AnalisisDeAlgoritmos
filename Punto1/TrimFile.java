import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TrimFile {
    public static void main(String[] args) {
        String nombreArchivoEntrada = "./conEspacios.txt";
        String nombreArchivoSalida = "./sinEspacios.txt";

        String linea = null;

        try {
            FileReader lectorArchivo = new FileReader(nombreArchivoEntrada);
            FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);

            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

            while ((linea = bufferLectura.readLine()) != null) {
                String nuevaLinea = null;
                for(int i=0; i< linea.length(); i++){
                    char simbolo = linea.charAt(i);
                    if( simbolo != ' '){
                        if(nuevaLinea == null){
                            nuevaLinea = simbolo+"";
                        }else {
                            nuevaLinea = nuevaLinea + simbolo;
                        }
                    }
                }
                if(nuevaLinea!=null){
                    bufferEscritura.write(nuevaLinea + "\n");
                }
            }

            bufferLectura.close();
            bufferEscritura.close();
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