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
        while(probabilidadjugador2 >= 100 && probabilidadjugador2 <= 0) {
            System.out.println("Ingrese bien la probabilidad del segundo jugador: ");
            probabilidadjugador2 = teclado.nextInt();
        }

    }

    static boolean jugarJuego(String j1, String j2) {

        Random rnd = new Random();
        int marcadorJug1 = 0;
        int marcadorJug2 = 0;
        String puntosJug1 = "0";
        String puntosJug2 = "0";
        boolean ganador = true;
        boolean finJuego = false;

        while (finJuego != true) {

            int randomGolpe = rnd.nextInt(2);
            String marcadorPuntos = "";

            if (randomGolpe == 0) {
                System.out.println("tiene el saque " + j1 );
                marcadorJug1 = marcadorJug1 + 1;

                if ((marcadorJug1 > 3) && (Math.abs(marcadorJug1 - marcadorJug2) > 1)) {
                    System.out.println();
                    System.out.println(j1 + " gana el juego");
                    System.out.println();
                    marcadorJug1 = 0;
                    marcadorJug2 = 0;
                    ganador = true;
                    finJuego = true;
                }
            }

            if (randomGolpe == 1) {
                System.out.println("tiene el saque " + j2 );
                marcadorJug2 = marcadorJug2 + 1;

                if ((marcadorJug2 > 3) && (Math.abs(marcadorJug2 - marcadorJug1) > 1)) {
                    System.out.println();
                    System.out.println(j2 + " gana el juego");
                    System.out.println();
                    marcadorJug1 = 0;
                    marcadorJug2 = 0;
                    ganador = false;
                    finJuego = true;
                }
            }

            if (marcadorJug1 == 1) {
                puntosJug1 = "15";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug1 == 2) {
                puntosJug1 = "30";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug1 == 3) {
                puntosJug1 = "40";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug2 == 1) {
                puntosJug2 = "15";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug2 == 2) {
                puntosJug2 = "30";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug2 == 3) {
                puntosJug2 = "40";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug1 > 3 && marcadorJug2 > 3 && marcadorJug1 == marcadorJug2) {
                marcadorPuntos = "deuce";
            }
            if (marcadorJug1 > 3 && marcadorJug1 > marcadorJug2) {
                puntosJug1 = "";
                puntosJug2 = "";
                marcadorPuntos = "ventaja " + j1;
            }
            if (marcadorJug2 > 3 && marcadorJug2 > marcadorJug1) {
                puntosJug1 = "";
                puntosJug2 = "";
                marcadorPuntos = "ventaja " + j2;
            }

            System.out.println(marcadorPuntos);
        }
        return ganador;
    }


}




