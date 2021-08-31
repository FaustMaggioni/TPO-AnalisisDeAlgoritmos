import java.util.Scanner;

public class CuantosPrimos {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el tope");
        int tope = sc.nextInt();
        int cantPrimos = cantPrimos(tope);
        System.out.println("Cantidad de nros primos: "+cantPrimos);
    }

    public static int cantPrimos(int tope){
        int cant=0;
        if(tope>=2) {
            cant=1;
            System.out.println("Primo: "+2);
            for (int i = 3;i<=tope;i=i+2){
                if(esPrimo(i)){
                    cant++;
                    System.out.println("Primo: "+i);
                }
            }
        }
        return cant;
    }

    public static boolean esPrimo(int j){
        boolean res=true;
        int aux = j-1;
        while(res && aux>1){
            if(j%aux ==0){
                res = false;
            }else{
                aux--;
            }
        }
        return res;
    }


}