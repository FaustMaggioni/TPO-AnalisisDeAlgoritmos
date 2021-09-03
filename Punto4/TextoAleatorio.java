import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TextoAleatorio {
    private static int TAM_LINEA = 10;
    private static int CANT_LINEAS = 30;
    public static void main(String[] args) {
        try{
            BufferedWriter buff = new BufferedWriter(new FileWriter("./textoAleatorio.txt"));
            double ti=System.nanoTime();
            for(int i=0; i<=CANT_LINEAS;i++) {
                String nuevaLinea = cadenaAleatoria(TAM_LINEA);
                buff.write(nuevaLinea + "\n");
            }
            double tf=System.nanoTime();
            double tt=tf-ti;
            System.out.println("tiempo: "+tt);
            buff.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static String cadenaAleatoria(int tamLinea){
        String nuevo = "";
        String alfanumericos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 0123456789";
        for (int i=0;i<=tamLinea;i++){
            int index = (int)(Math.random()*alfanumericos.length());
            nuevo = nuevo + alfanumericos.charAt(index);
        }
        return nuevo;
    }

    public static String textoAleatorio(int tamLinea, int cantLineas){
        String linea="";
        String res="";
        String alfanumericos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 0123456789";
        for(int i=0; i<=cantLineas;i++){
            for (int j=0;j<=tamLinea;j++){
                int index = (int)(Math.random()*alfanumericos.length());
                linea = linea + alfanumericos.charAt(index);
            }
            res=res+linea+"\n";
            linea="";
        }
        return res;
    }
}