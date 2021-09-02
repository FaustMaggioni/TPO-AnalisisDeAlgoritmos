package ejemplos_InOut.TP0;

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

    public static String arrayToString(double[] promedios){
        String res="-->";
        for(int i=0; i<promedios.length; i++){
            res=res+" "+promedios[i]+",";
        }
        return res;
    }


}
