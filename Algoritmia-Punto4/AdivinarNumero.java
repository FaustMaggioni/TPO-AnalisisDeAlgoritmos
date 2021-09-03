import java.util.Scanner;

public class AdivinarNumero {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Escriba el tope");
        int tope = sc.nextInt();
        juego(tope);
    }

    public static void juego(int tope){
        System.out.println(tope);
        int nroSecreto = (int) (Math.random()*(tope+1));
        boolean haAdivinado = false;
        while (!haAdivinado){
            System.out.println("Adivine entre 0 y "+tope);
            int intento = sc.nextInt();
            haAdivinado = verifSiGano(intento,nroSecreto);
        }
    }

    private static boolean verifSiGano(int intento, int nroSecreto){
        boolean haAdivinado=false;
        if(intento == nroSecreto){
            System.out.println("Ganaste!");
            haAdivinado = true;
        }else{
            if(intento > nroSecreto){
                System.out.println("El numero a adivinar es MENOR que el que dijiste");
            }else{
                System.out.println("El numero a adivinar es MAYOR que el que dijiste");
            }
        }
        return haAdivinado;
    }
}