package ar.edu.unju.escmi.tp4.ejercicio3;

import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Paciente> pacientes = new TreeSet<>();
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1) Alta de paciente");
            System.out.println("2) Mostrar todos los pacientes");
            System.out.println("3) Mostrar el paciente en la mitad de la lista");
            System.out.println("4) Mostrar el primer paciente de la lista");
            System.out.println("5) Mostrar el último paciente de la lista");
            System.out.println("6) Filtrar por historia clínica");
            System.out.println("7) Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Paciente nuevo = new Paciente();
                    System.out.print("Ingrese DNI: ");
                    nuevo.setDni(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    nuevo.setNombre(sc.nextLine());
                    System.out.print("Ingrese Apellido: ");
                    nuevo.setApellido(sc.nextLine());
                    System.out.print("Ingrese Número de Historia Clínica: ");
                    nuevo.setNumeroHistoriaClinica(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Ingrese Obra Social: ");
                    nuevo.setObraSocial(sc.nextLine());

                    if (pacientes.add(nuevo)) {
                        System.out.println("Paciente agregado con éxito.");
                    } else {
                        System.out.println("Ya existe un paciente con ese número de historia clínica.");
                    }
                    break;

                case 2:
                    System.out.println("Lista de pacientes:");
                    pacientes.stream().forEach(System.out::println);
                    break;

                case 3:
                    if (!pacientes.isEmpty()) {
                        int mitad = pacientes.size() / 2;
                        int i = 0;
                        for (Paciente p : pacientes) {
                            if (i == mitad) {
                                System.out.println("Paciente en la mitad: " + p);
                                break;
                            }
                            i++;
                        }
                    } else {
                        System.out.println("No hay pacientes cargados.");
                    }
                    break;

                case 4:
                    if (!pacientes.isEmpty()) {
                        System.out.println("Primer paciente: " + pacientes.first());
                    } else {
                        System.out.println("No hay pacientes cargados.");
                    }
                    break;

                case 5:
                    if (!pacientes.isEmpty()) {
                        System.out.println("Último paciente: " + pacientes.last());
                    } else {
                        System.out.println("No hay pacientes cargados.");
                    }
                    break;

                case 6:
                    if (!pacientes.isEmpty()) {
                        System.out.print("Ingrese número de historia clínica para filtrar: ");
                        int hc = sc.nextInt();
                        System.out.println("Pacientes con historia clínica mayor a " + hc + ":");
                        pacientes.stream()
                                .filter(p -> p.getNumeroHistoriaClinica() > hc)
                                .forEach(System.out::println);
                    } else {
                        System.out.println("No hay pacientes cargados.");
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);

        sc.close();
    }
}