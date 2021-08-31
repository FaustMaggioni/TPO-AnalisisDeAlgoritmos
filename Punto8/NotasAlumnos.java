import java.util.Random;

public class NotasAlumnos {
    static int CANT_ALUMNOS = 20;
    static int CANT_MATERIAS = 5;
    static int MAX_NOTA = 10;
    public static void main(String[] args){
        int[][] notasAlumnos = getMatriz();
        double[] promediosAlumnos = mediaCadaAlumno(notasAlumnos);
        double[] promediosMateria = mediaCadaMateria(notasAlumnos);
        double mediaTotal = mediaTotalClase(notasAlumnos);

        System.out.println("Promedios alumnos: \n"+ arrayToString(promediosAlumnos));
        System.out.println("Media total: "+mediaTotal);

        quickSort(promediosAlumnos,0,CANT_ALUMNOS-1);
        System.out.println("Promedios alumnos: \n"+ arrayToString(promediosAlumnos));
    }

    private static void quickSort(double[] arr, int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, pi + 1, high);
            quickSort(arr, low, pi - 1);
        }
    }

    private static int partition(double[] arr, int low, int high) {
        double pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++){
            if (arr[j] > pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static String arrayToString(double[] promedios){
        String res="-->";
        for(int i=0; i<promedios.length; i++){
            res=res+" "+promedios[i]+",";
        }
        return res;
    }

    private static int[][] getMatriz(){
        Random generator = new Random();
        int[][] notasAlumnos = new int[CANT_MATERIAS][CANT_ALUMNOS];
        for(int i=0; i<CANT_MATERIAS; i++){
            for(int j=0; j<CANT_ALUMNOS; j++){
                int nota = generator.nextInt(MAX_NOTA)+1;
                notasAlumnos[i][j] = nota;
            }
        }
        return notasAlumnos;
    }

    private static double[] mediaCadaAlumno(int[][] matriz){
        double[] promediosAlumnos = new double[CANT_ALUMNOS];
        for(int i=0; i<CANT_ALUMNOS; i++){
            int sumaAlumno=0;
            for(int j=0; j<CANT_MATERIAS; j++){
                sumaAlumno=sumaAlumno+matriz[j][i];
            }
            double promedio= sumaAlumno/CANT_MATERIAS;
            promediosAlumnos[i] = promedio;
        }
        return promediosAlumnos;
    }

    private static double[] mediaCadaMateria(int[][] matriz){
        double[] promediosMaterias = new double[CANT_MATERIAS];
        for(int i=0; i<CANT_MATERIAS; i++){
            int sumaMateria=0;
            for(int j=0; j<CANT_ALUMNOS; j++){
                sumaMateria=sumaMateria+matriz[i][j];
            }
            double promedio= sumaMateria/CANT_ALUMNOS;
            promediosMaterias[i] = promedio;
        }
        return promediosMaterias;
    }

    private static double mediaTotalClase(int[][] matriz){
        double suma = 0;
        for(int i=0; i<CANT_MATERIAS; i++){
            for(int j=0; j<CANT_ALUMNOS; j++){
                suma=suma+matriz[i][j];
            }
        }
        double promedio = suma/(CANT_ALUMNOS*CANT_MATERIAS);
        return promedio;
    }

}