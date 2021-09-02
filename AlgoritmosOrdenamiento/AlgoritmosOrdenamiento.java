package ejemplos_InOut.TP0.AlgoritmosOrdenamiento;

import java.util.ArrayList;
import java.util.Collections;

public class AlgoritmosOrdenamiento {
    public static void quickSortArregloNrosReales(double[] arr, int min, int max){
        if (min < max){
            int pi = particion(arr, min, max);
            quickSortArregloNrosReales(arr, pi + 1, max);
            quickSortArregloNrosReales(arr, min, pi - 1);
        }
    }
    private static int particion(double[] arr, int min, int max) {
        double pivot = arr[max];
        int i = (min - 1);

        for(int j = min; j <= max - 1; j++){
            if (arr[j] > pivot){
                i++;
                intercambiar(arr, i, j);
            }
        }
        intercambiar(arr, i + 1, max);
        return (i + 1);
    }
    private static void intercambiar(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mergeSortArregloNrosReales(double arr[], int izq, int der) {
        if (izq < der) {
            int medio = izq+ (der-izq)/2;
            mergeSortArregloNrosReales(arr, medio + 1, der);
            mergeSortArregloNrosReales(arr, izq, medio);
            merge(arr, izq, medio, der);
        }
    }
    private static void merge(double arr[], int izq, int medio, int derecha) {
        int n1 = medio - izq + 1;
        int n2 = derecha - medio;

        double tempIzq[] = new double[n1];
        double tempDer[] = new double[n2];

        for (int i = 0; i < n1; i++) {
            tempIzq[i] = arr[izq + i];
        }
        for (int j = 0; j < n2; j++) {
            tempDer[j] = arr[medio + 1 + j];
        }

        int i = 0, j = 0;
        int k = izq;

        while (i < n1 && j < n2) {
            if (tempIzq[i] >= tempDer[j]) {
                arr[k] = tempIzq[i];
                i++;
            }
            else {
                arr[k] = tempDer[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = tempIzq[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = tempDer[j];
            j++;
            k++;
        }
    }

    public static void quickSortLista(ArrayList list, int min, int max){
        if (min < max){
            int pi = particionList(list, min, max);
            quickSortLista(list, pi + 1, max);
            quickSortLista(list, min, pi - 1);
        }
    }
    public static int particionList(ArrayList list, int min, int max){
        Comparable pivot = (Comparable) list.get(max);
        int i = (min - 1);

        for(int j = min; j <= max - 1; j++){
            Comparable elemJ = (Comparable)list.get(j);
            if ((elemJ).compareTo(pivot) > 0) {
                i++;
                intercambiarLista(list, i, j);
            }
        }
        intercambiarLista(list, i + 1, max);
        return (i + 1);
    }
    private static void intercambiarLista(ArrayList list, int i, int j) {
        Collections.swap(list,i,j);
    }

    public static void mergeSortLista(ArrayList list, int izq, int der){
        if (izq < der) {
            int medio = izq+ (der-izq)/2;
            mergeSortLista(list, medio + 1, der);
            mergeSortLista(list, izq, medio);
            mergeList(list, izq, medio, der);
        }
    }

    private static void mergeList(ArrayList list,int izq, int medio, int derecha){
        int n1 = medio - izq + 1;
        int n2 = derecha - medio;

        Comparable tempIzq[] = new Comparable[n1];
        Comparable tempDer[] = new Comparable[n2];

        for (int i = 0; i < n1; i++) {
            tempIzq[i] = (Comparable) list.get(izq + i);
        }
        for (int j = 0; j < n2; j++) {
            tempDer[j] = (Comparable) list.get(medio + 1 + j);
        }

        int i = 0, j = 0;
        int k = izq;

        while (i < n1 && j < n2) {
            if (tempIzq[i].compareTo(tempDer[j]) > 0) {
                list.remove(k);
                list.add(k,tempIzq[i]);
                i++;
            }
            else {
                list.remove(k);
                list.add(k,tempDer[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            list.remove(k);
            list.add(k,tempIzq[i]);
            i++;
            k++;
        }
        while (j < n2) {
            list.remove(k);
            list.add(k,tempDer[j]);
            j++;
            k++;
        }
    }

    public static String arrayToString(double[] arr){
        String res="[";
        for(int i=0; i<arr.length; i++){
            String  puntuacion = ",";
            if (i==arr.length-1) puntuacion =" ]";
            res=res+" "+arr[i]+puntuacion;
        }
        return res;
    }
}
