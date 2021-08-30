import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TextoAleatorio {
    public static void main(String[] args) {
        int cantLineas = (int)(Math.random()*30);
        try{
            BufferedWriter buff = new BufferedWriter(new FileWriter("./textoAleatorio.txt"));
            for(int i=0; i<=cantLineas;i++) {
                String nuevaLinea = cadenaAleatoria();
                buff.write(nuevaLinea + "\n");
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

    public static String cadenaAleatoria(){
        String nuevo = null;
        int cantCaracteres = (int)(Math.random()*100);
        String alfanumericos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz "
                + "0123456789";
        for (int i=0;i<=cantCaracteres;i++){
            int index = (int)(Math.random()*alfanumericos.length());
            if(nuevo == null){
                nuevo = alfanumericos.charAt(index)+"";
            }else{
                nuevo = nuevo + alfanumericos.charAt(index);
            }
        }
        return nuevo;
    }
}