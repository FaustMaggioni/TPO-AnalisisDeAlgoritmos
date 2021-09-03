import java.util.Scanner;

public class CuantosPrimos {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el tope");
        int tope = sc.nextInt();
        double tiempoInicial = System.nanoTime();
        int cantPrimos = cantPrimos(tope);
        double tiempoFinal = System.nanoTime();
        double tiempoTotal = tiempoFinal - tiempoInicial;
        System.out.println("tiempo: "+tiempoTotal);
        System.out.println("Cantidad de nros primos: "+cantPrimos);
    }

    public static int cantPrimos(int tope){
        int cant=0;
        if(tope>=2) {
            cant=1;
            for (int i = 3;i<=tope;i=i+2){
                if(esPrimo(i)){
                    cant++;
                }
            }
        }
        return cant;
    }

    public static boolean esPrimo(int j){
        boolean res=true;
        int aux = (j/2);
        if(aux % 2 == 0) aux=aux-1;
        while(res && aux>=3){
            if(j%aux == 0){
                res = false;
            }else{
                aux=aux-2;
            }
        }
        return res;
    }


}