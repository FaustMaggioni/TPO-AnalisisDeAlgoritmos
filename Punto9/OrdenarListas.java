package ejemplos_InOut.TP0.Punto9;

import java.util.ArrayList;
import java.util.Random;

import static ejemplos_InOut.TP0.AlgoritmosOrdenamiento.AlgoritmosOrdenamiento.*;

public class OrdenarListas {
    private static int CANT_LISTA_A = 100;
    private static int CANT_LISTA_B = 60;
    public static void main(String[] args){
        ArrayList<Integer> listaA = new ArrayList<>();
        ArrayList<Integer> listaB = new ArrayList<>();

        llenarLista(listaA,CANT_LISTA_A);
        llenarLista(listaB, CANT_LISTA_B);

        quickSortLista(listaA,0,CANT_LISTA_A-1);
        mergeSortLista(listaB,0,CANT_LISTA_B-1);

        System.out.println("Lista A: "+listaA);
        System.out.println("Lista B: "+listaB);

        double ti = System.nanoTime();
        ArrayList listaC = crearListaAPartirDe(listaA,listaB);
        double tf = System.nanoTime();
        System.out.println("Tiempo: "+(tf-ti));
        System.out.println("Lista C: "+listaC);

    }

    public static void llenarLista(ArrayList lista, int cant){
        Random generator = new Random();
        for(int i=1;i<=cant;i++){
            int nro = generator.nextInt(100);
            lista.add(nro);
        }
    }

    public static ArrayList<Integer> crearListaAPartirDe(ArrayList listaA, ArrayList listaB){
        ArrayList<Integer> listaC = new ArrayList<>();

        int elemA = (int) listaA.get(0);
        int elemB = (int) listaB.get(0);

        while(!listaA.isEmpty() || !listaB.isEmpty()){
            if(!listaA.isEmpty() && (listaB.isEmpty() || elemA >= elemB)){
                listaC.add(elemA);
                listaA.remove(0);
                if (!listaA.isEmpty()) elemA = (int) listaA.get(0);
            }else{
                listaC.add(elemB);
                listaB.remove(0);
                if (!listaB.isEmpty()) elemB = (int) listaB.get(0);
            }
        }

        return listaC;
    }
}
