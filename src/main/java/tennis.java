import java.util.Random;
import java.util.Scanner;

public class tennis {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int revancha = 1;

        jugadores();
        while(revancha == 1){
            System.out.println("Quieren tener la revancha tiene que poner 1 para si y 0 para no ");
            revancha = teclado.nextInt();
            while(revancha == 1){
                jugadores();
            }
        }

    }

    static void jugadores(){
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
        jugarSet(set, jugador1, jugador2, torneo);
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

                marcadorJug1 = marcadorJug1 + 1;
                if ((marcadorJug1 > 3) && (Math.abs(marcadorJug1 - marcadorJug2) > 1)) {
                    System.out.println(j1);
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

    static void jugarSet(float sets, String j1, String j2, String torneo) {


        int juegosJug1 = 0;
        int juegosJug2 = 0;
        int setJug1 = 0;
        int setJug2 = 0;
        float set = ((sets + 1)/2);
        boolean finPartido = false;

        while (!finPartido) {
            boolean resultadoJuego = jugarJuego(j1, j2);
            if (resultadoJuego) {
                juegosJug1 = juegosJug1 + 1;
            }else {
                juegosJug2 = juegosJug2 + 1;
            }

            if (juegosJug1 == 6 && juegosJug2 == 6) {
                System.out.println("Tie Break");
            }

            if (juegosJug1 >= 6 && (Math.abs(juegosJug1 - juegosJug2) > 1) || juegosJug1 == 7 && juegosJug2 == 6) {
                setJug1 = setJug1 + 1;
                System.out.println(j1 + " gana el set por " + juegosJug1 + " a " + juegosJug2);
                System.out.println();
                juegosJug1 = 0;
                juegosJug2 = 0;
                if (setJug1 == set && setJug1 > setJug2) {
                    System.out.println(j1 + " gana el partido por " + setJug1 + " sets a " + setJug2 + " en el torneo: " + torneo);
                    finPartido = true;
                }
            }
            if (juegosJug2 >= 6 && (Math.abs(juegosJug2 - juegosJug1) > 1) || juegosJug2 == 7 && juegosJug1 == 6) {
                setJug2 = setJug2 + 1;
                System.out.println(j2 + " gana el set por " + juegosJug2 + " a " + juegosJug1);
                System.out.println();
                juegosJug1 = 0;
                juegosJug2 = 0;
                if (setJug2 == set && setJug2 > setJug1) {
                    System.out.println(j2 + " gana el partido por " + setJug2 + " sets a " + setJug1 + " en el torneo: " + torneo);
                    finPartido = true;
                }
            }
        }
    }
}




