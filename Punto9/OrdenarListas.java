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

        ArrayList listaC = crearListaAPartirDe(listaA,listaB);
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
        int tamA = listaA.size();
        int tamB = listaB.size();
        for (int i=0; i<tamA; i++){
            int nuevo = (int) listaA.get(i);
            listaC.add(nuevo);
        }
        for (int i=0; i<tamB; i++){
            int nuevo = (int) listaB.get(i);
            listaC.add(nuevo);
        }
        return listaC;
    }
}
