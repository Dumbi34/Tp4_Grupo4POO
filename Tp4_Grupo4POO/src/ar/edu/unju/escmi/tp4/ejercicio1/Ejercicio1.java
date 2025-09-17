package ar.edu.unju.escmi.tp4.ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU JUGADORES ---");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Modificar jugador");
            System.out.println("3 - Eliminar jugador");
            System.out.println("4 - Mostrar jugadores");
            System.out.println("5 - Cantidad de jugadores");
            System.out.println("6 - Limpiar lista");
            System.out.println("7 - Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Jugador j = new Jugador();
                    System.out.print("DNI: ");
                    j.setDni(sc.nextLine());
                    System.out.print("Nombre: ");
                    j.setNombre(sc.nextLine());
                    System.out.print("Equipo: ");
                    j.setEquipo(sc.nextLine());
                    System.out.print("Nacionalidad: ");
                    j.setNacionalidad(sc.nextLine());
                    System.out.print("Estatura: ");
                    j.setEstatura(sc.nextDouble());
                    sc.nextLine();
                    jugadores.add(j);
                    break;

                case 2:
                    System.out.print("Ingrese DNI a modificar: ");
                    String dni = sc.nextLine();
                    boolean encontrado = false;
                    for (Jugador jug : jugadores) {
                        if (jug.getDni().equals(dni)) {
                            encontrado = true;
                            jug.mostrarDatos();
                            System.out.print("Nuevo nombre: ");
                            jug.setNombre(sc.nextLine());
                            System.out.print("Nuevo equipo: ");
                            jug.setEquipo(sc.nextLine());
                            System.out.print("Nueva nacionalidad: ");
                            jug.setNacionalidad(sc.nextLine());
                            System.out.print("Nueva estatura: ");
                            jug.setEstatura(sc.nextDouble());
                            sc.nextLine();
                        }
                    }
                    if (!encontrado)
                        System.out.println("No se encontró el DNI.");
                    break;

                case 3:
                    System.out.print("Ingrese DNI a eliminar: ");
                    String dniEliminar = sc.nextLine();
                    jugadores.removeIf(jug -> jug.getDni().equals(dniEliminar));
                    break;

                case 4:
                    jugadores.forEach(Jugador::mostrarDatos);
                    break;

                case 5:
                    System.out.println("Cantidad de jugadores: " + jugadores.size());
                    break;

                case 6:
                    jugadores.clear();
                    System.out.println("Lista vaciada.");
                    break;
            }
        } while (opcion != 7);

        sc.close();
    }
}
