import java.util.Random;
import java.util.Scanner;

public class tennis {

    public static void main(String[] args) {

        String jugador1 = "";
        String jugador2 = "";
        String torneo = "";
        int set = 0;
        int probabilidadjugador1 = 0;
        int probabilidadjugador2 = 0;


        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre y apellido del primero jugador: ");
        jugador1 = teclado.nextLine();

        System.out.println("Ingrese el nombre y apellido del segundo jugador: ");
        jugador2 = teclado.nextLine();

        System.out.println("Nombre del torneo: ");
        torneo = teclado.nextLine();

        System.out.println("Cantidad del set puede ser al mejor de 3 o al mejor de 5: ");
        set = teclado.nextInt();
        while(set != 3 && set != 5){
            System.out.println("Ingrese bien el set: ");
            set = teclado.nextInt();
        }

        System.out.println("Probabilidad de que "+ jugador1 + " Gane");
        probabilidadjugador1 = teclado.nextInt();
        while(probabilidadjugador1 >= 100 && probabilidadjugador1 <= 0){
            System.out.println("Ingrese bien la probabilidad del primer jugador: ");
            probabilidadjugador1 = teclado.nextInt();
        }

        System.out.println("Probabilidad de que "+ jugador2 + " Gane");
        probabilidadjugador2 = teclado.nextInt();
        while(probabilidadjugador2 >= 100 && probabilidadjugador2 <= 0){
            System.out.println("Ingrese bien la probabilidad del segundo jugador: ");
            probabilidadjugador2 = teclado.nextInt();
        }

        

    }

}




