import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import java.util.*;

public class tennis {

    public static void main(String[] args) {
        jugar();
    }

    static void jugar() {
        String jugador1 = "";
        String jugador2 = "";
        String torneo = "";
        int set = 0;
        int probabilidadjugador1 = 0;
        int probabilidadjugador2 = 0;
        String revancha = "";

        Scanner teclado = new Scanner(System.in);

        // Se ingresa el nombre de los dos jugadores
        jugador1 = ingresarNombreJugador("primero", teclado);
        jugador2 = ingresarNombreJugador("segundo", teclado);

        // Se ingresa el nombre del torneo
        torneo = ingresarNombreTorneo(teclado);

        // Se ingresa la cantidad de sets que se va a jugar
        set = ingresarCantidadSet(teclado);

        // Se ingresan las probabilidades de ganar de cada jugador
        probabilidadjugador1 = ingresarProbabilidad(jugador1, teclado);
        probabilidadjugador2 = ingresarProbabilidad(jugador2, teclado);

        // Se simula el partido
        jugarPartido(set, jugador1, jugador2, torneo, probabilidadjugador1, probabilidadjugador2);

        // Se pregunta si se quiere jugar nuevamente, con los mismos datos ingresados
        teclado.nextLine();
        revancha = ingresarRevancha(teclado);

        while (Objects.equals(revancha.toLowerCase(), "si")) {
            jugarPartido(set, jugador1, jugador2, torneo, probabilidadjugador1, probabilidadjugador2);
            revancha = ingresarRevancha(teclado);
        }
    }

    private static String ingresarRevancha(Scanner teclado) {
        String revancha;
        System.out.println("Si quiere tener la revancha coloque SI, sino coloque NO: ");
        revancha = teclado.nextLine();

        while (!(Objects.equals(revancha.toLowerCase(), "si")) && !(Objects.equals(revancha.toLowerCase(), "no"))) {
            System.out.println("Ups, hubo un error al ingresar la revancha, por favor ingrese nuevamente la revancha: ");
            revancha = teclado.nextLine();
        }
        return revancha;
    }

    // TODO: Validar que se ingrese un número
    private static int ingresarProbabilidad(String jugador, Scanner teclado) {
        int probabilidadjugador = 0;
        boolean continua;

        do {
            try {
                System.out.println("Probabilidad de que " + jugador + " Gane");
                probabilidadjugador = teclado.nextInt();
                while (probabilidadjugador >= 101 || probabilidadjugador < 1) {
                    System.out.println("Ups, hubo un error al ingresar la probabilidad del primer jugador, por favor ingrese nuevamente el valor de la probabilidad, el rango seria entre 1 al 100: ");
                    probabilidadjugador = teclado.nextInt();
                }
                return probabilidadjugador;
            }catch (InputMismatchException ex){
                System.out.println("Debe ingresar obligatoriamente un número entero.");
                teclado.next();
                continua = true;
            }
        }while(continua);

        return probabilidadjugador;
    }

    // TODO: Validar que se ingrese un número
    private static int ingresarCantidadSet(Scanner teclado) {
        int set = 0;
        boolean continua;

        do {
            try {
                System.out.println("Cantidad del set puede ser al mejor de 3 o al mejor de 5: ");
                set = teclado.nextInt();
                while (set != 3 && set != 5) {
                    System.out.println("Ups, hubo un error al ingresar el set, por favor ingrese si es al mejor de 3 o al mejor de 5: ");
                    set = teclado.nextInt();
                }
                return set;
            } catch (InputMismatchException ex) {
                System.out.println("Debe ingresar obligatoriamente un número entero.");
                teclado.next();
                continua = true;
            }
        } while (continua);
        return set;
    }

    private static String ingresarNombreTorneo(Scanner teclado) {
        System.out.println("Nombre del torneo: ");
        return teclado.nextLine();
    }

    private static String ingresarNombreJugador(String ordenJugador, Scanner teclado) {
        System.out.println("Ingrese el nombre y apellido del " + ordenJugador + " Jugador");
        return teclado.nextLine();
    }

    static boolean jugarJuego(String j1, String j2, int probabilidadjugador1, int probabilidadjugador2) {

        int randomGolpe = 0;
        int marcadorJug1 = 0;
        int marcadorJug2 = 0;
        String puntosJug1 = "0";
        String puntosJug2 = "0";
        boolean ganador = true;
        boolean finJuego = false;

        while (finJuego != true) {
            randomGolpe = calcularGolpe(probabilidadjugador1, probabilidadjugador2);

            String marcadorPuntos = "";

            if (randomGolpe == 0) {
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

    // Método que calcula el resultado del punto. Retorna 0 si ganó el jugador 1, y 1 si lo ganó el jugador 2
    private static int calcularGolpe(int probabilidadjugador1, int probabilidadjugador2) {

        Random generadorRandom = new Random();

        int randomGolpe2 = generadorRandom.nextInt(probabilidadjugador2 + 1);
        int randomGolpe1 = generadorRandom.nextInt(probabilidadjugador1 + 1);

        while (randomGolpe1 == randomGolpe2) {
            randomGolpe1 = generadorRandom.nextInt(probabilidadjugador1 + 1);
            randomGolpe2 = generadorRandom.nextInt(probabilidadjugador2 + 1);
        }

        return randomGolpe1 > randomGolpe2 ? 0 : 1;
    }

    static void jugarPartido(float sets, String j1, String j2, String torneo, int probabilidadjugador1, int probabilidadjugador2) {

        int juegosJug1 = 0;
        int juegosJug2 = 0;
        int setJug1 = 0;
        int setJug2 = 0;
        float set = ((sets + 1) / 2);
        boolean finPartido = false;

        String jugadorConSaque = j1;
        String jugadorUltimoSaque = j1;

        ArrayList<Integer> juegosGanadosJ1 = new ArrayList<Integer>();
        ArrayList<Integer> juegosGanadosJ2 = new ArrayList<Integer>();

        while (!finPartido) {

            System.out.println("Saca el jugador: " + jugadorConSaque);

            boolean resultadoJuego = jugarJuego(j1, j2, probabilidadjugador1, probabilidadjugador2);

            // Se calcula próximo jugador con saque
            jugadorConSaque = Objects.equals(j1, jugadorConSaque) ? j2 : j1;

            if (resultadoJuego) {
                juegosJug1 = juegosJug1 + 1;
            } else {
                juegosJug2 = juegosJug2 + 1;
            }

            // Se valida que exista situación de TieBreak. Si es así, se aplica lógica de esta modalidad al siguiente juego
            if (juegosJug1 == 6 && juegosJug2 == 6) {
                System.out.println("Tie Break");
                boolean resultadoTieBreak = jugarTieBreak(j1, j2, probabilidadjugador1, probabilidadjugador2, jugadorConSaque);
                if (resultadoTieBreak) {
                    juegosJug1 = juegosJug1 + 1;
                } else {
                    juegosJug2 = juegosJug2 + 1;
                }
            }

            // Se valida que el jugador 1 ganó el set
            if (juegosJug1 >= 6 && (Math.abs(juegosJug1 - juegosJug2) > 1) || juegosJug1 == 7 && juegosJug2 == 6) {
                setJug1 = setJug1 + 1;
                System.out.println(j1 + " gana el set por " + juegosJug1 + " a " + juegosJug2);
                System.out.println();

                juegosGanadosJ1.add(juegosJug1);
                juegosGanadosJ2.add(juegosJug2);

                juegosJug1 = 0;
                juegosJug2 = 0;

                // Se calcula qué jugador comienza sacando el próximo set
                jugadorConSaque = Objects.equals(j1, jugadorUltimoSaque) ? j2 : j1;
                jugadorUltimoSaque = jugadorConSaque;

                if (setJug1 == set && setJug1 > setJug2) {
                    System.out.println(j1 + " gana el partido por " + setJug1 + " sets a " + setJug2 + " en el torneo: " + torneo + "\n");
                    System.out.println("-- Tabla resultado Final --");
                    mostrarTablaResultado(j1, j2, juegosGanadosJ1, juegosGanadosJ2);
                    finPartido = true;
                }
                else {
                    System.out.println("-- Tabla resultado Parcial -- ");
                    mostrarTablaResultado(j1, j2, juegosGanadosJ1, juegosGanadosJ2);
                }
            }

            // Se valida que el jugador 2 ganó el set
            if (juegosJug2 >= 6 && (Math.abs(juegosJug2 - juegosJug1) > 1) || juegosJug2 == 7 && juegosJug1 == 6) {
                setJug2 = setJug2 + 1;
                System.out.println(j2 + " gana el set por " + juegosJug2 + " a " + juegosJug1);
                System.out.println();

                juegosGanadosJ1.add(juegosJug1);
                juegosGanadosJ2.add(juegosJug2);

                juegosJug1 = 0;
                juegosJug2 = 0;

                // Se calcula qué jugador comienza sacando el próximo set
                jugadorConSaque = Objects.equals(j1, jugadorUltimoSaque) ? j2 : j1;
                jugadorUltimoSaque = jugadorConSaque;

                if (setJug2 == set && setJug2 > setJug1) {
                    System.out.println(j2 + " gana el partido por " + setJug2 + " sets a " + setJug1 + " en el torneo: " + torneo + "\n");
                    System.out.println("-- Tabla resultado Final --");
                    mostrarTablaResultado(j1, j2, juegosGanadosJ1, juegosGanadosJ2);
                    finPartido = true;
                }
                else {
                    System.out.println("-- Tabla resultado Parcial -- ");
                    mostrarTablaResultado(j1, j2, juegosGanadosJ1, juegosGanadosJ2);
                }
            }
        }
    }

    private static void mostrarTablaResultado(String j1, String j2, ArrayList<Integer> juegosGanadosJ1, ArrayList<Integer> juegosGanadosJ2) {

        System.out.print(String.format("%-30s", j1) + "|| ");
        for (Integer juegosGanados: juegosGanadosJ1) {
            System.out.print(juegosGanados + " || ");
        }
        System.out.println();
        System.out.print(String.format("%-30s", j2) + "|| " );
        for (Integer juegosGanados: juegosGanadosJ2) {
            System.out.print(juegosGanados + " || ");
        }
        System.out.println("\n");
    }

    static boolean jugarTieBreak(String j1, String j2, int probabilidadjugador1, int probabilidadjugador2, String ultimoJugadorSaque) {

        int randomGolpe = 0;
        int marcadorJug1 = 0;
        int marcadorJug2 = 0;
        boolean ganador = true;
        boolean finJuego = false;
        String jugadorConSaque = Objects.equals(j1, ultimoJugadorSaque) ? j2 : j1;

        int contadorPuntos = 0;

        while (finJuego != true) {

            // Se muestra qué jugador tiene el saque
            System.out.println("Saca el jugador " + jugadorConSaque);

            contadorPuntos += 1;

            // Se calcula qué jugador tendrá el saque en el próximo punto
            if (contadorPuntos % 2 != 0) {
                jugadorConSaque = Objects.equals(j1, jugadorConSaque) ? j2 : j1;
            }

            randomGolpe = calcularGolpe(probabilidadjugador1, probabilidadjugador2);

            String marcadorPuntos = "";

            // Si el punto fue para el jugador 1, se actualiza el marcador y se lo muestra
            if (randomGolpe == 0) {
                marcadorJug1 = marcadorJug1 + 1;
                marcadorPuntos = marcadorJug1 + "-" + marcadorJug2;
                System.out.println(marcadorPuntos);
                // Se valida que el jugador 1 cumpla con las reglas para ganar el tie break
                if ((marcadorJug1 >= 7 ) && (Math.abs(marcadorJug1 - marcadorJug2) > 1)) {
                    System.out.println();
                    System.out.println(j1 + " gana el juego");
                    System.out.println();
                    marcadorJug1 = 0;
                    marcadorJug2 = 0;
                    ganador = true;
                    finJuego = true;
                }
            }

            // Si el punto fue para el jugador 2, se actualiza el marcador y se lo muestra
            if (randomGolpe == 1) {
                marcadorJug2 = marcadorJug2 + 1;
                marcadorPuntos = marcadorJug1 + "-" + marcadorJug2;
                System.out.println(marcadorPuntos);
                // Se valida que el jugador 2 cumpla con las reglas para ganar el tie break
                if ((marcadorJug2 >= 7) && (Math.abs(marcadorJug2 - marcadorJug1) > 1)) {
                    System.out.println();
                    System.out.println(j2 + " gana el juego");
                    System.out.println();
                    marcadorJug1 = 0;
                    marcadorJug2 = 0;
                    ganador = false;
                    finJuego = true;
                }
            }
        }
        return ganador;
    }
}




