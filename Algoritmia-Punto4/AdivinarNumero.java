import java.util.Scanner;

public class AdivinarNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el tope");
        int tope = sc.nextInt();
        juego(tope);
    }
    public static void juego(int tope){
        Scanner sc = new Scanner(System.in);
        System.out.println(tope);
        int nroSecreto = (int) (Math.random()*tope);
        boolean haAdivinado = false;
        while (!haAdivinado){
            System.out.println("Adivina");
            int intento = sc.nextInt();
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
        }
    }
}