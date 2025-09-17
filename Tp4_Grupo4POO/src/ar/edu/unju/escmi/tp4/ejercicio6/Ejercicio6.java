package ar.edu.unju.escmi.tp4.ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ LIBROS ---");
            System.out.println("1 - Alta de Libro");
            System.out.println("2 - Mostrar libros");
            System.out.println("3 - Buscar y mostrar un libro");
            System.out.println("4 - Ordenar libros por título");
            System.out.println("5 - Modificar datos de un libro");
            System.out.println("6 - Eliminar un libro");
            System.out.println("7 - Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:

                    Libro libro = new Libro();
                    System.out.print("Ingrese ISBN: ");
                    libro.setIsbn(sc.nextLine());
                    System.out.print("Ingrese Título: ");
                    libro.setTitulo(sc.nextLine());
                    System.out.print("Ingrese cantidad de páginas: ");
                    libro.setCantidadPaginas(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Ingrese Autor: ");
                    libro.setAutor(sc.nextLine());
                    listaLibros.add(libro);
                    System.out.println("Libro agregado con éxito.");
                    break;

                case 2:

                    if (listaLibros.isEmpty()) {
                        System.out.println("No hay libros cargados.");
                    } else {
                        for (Libro l : listaLibros) {
                            l.mostrarDatos();
                        }
                    }
                    break;

                case 3:

                    System.out.print("Ingrese ISBN a buscar: ");
                    String isbnBuscar = sc.nextLine();
                    boolean encontrado = false;
                    for (Libro l : listaLibros) {
                        if (l.getIsbn().equals(isbnBuscar)) {
                            l.mostrarDatos();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 4:

                    Collections.sort(listaLibros);
                    System.out.println("Libros ordenados por título.");
                    break;

                case 5:

                    System.out.print("Ingrese ISBN del libro a modificar: ");
                    String isbnMod = sc.nextLine();
                    boolean modificado = false;
                    for (Libro l : listaLibros) {
                        if (l.getIsbn().equals(isbnMod)) {
                            System.out.println("Datos actuales:");
                            l.mostrarDatos();

                            System.out.print("Ingrese nuevo título: ");
                            l.setTitulo(sc.nextLine());
                            System.out.print("Ingrese nueva cantidad de páginas: ");
                            l.setCantidadPaginas(sc.nextInt());
                            sc.nextLine();
                            System.out.print("Ingrese nuevo autor: ");
                            l.setAutor(sc.nextLine());

                            modificado = true;
                            System.out.println("Libro modificado correctamente.");
                            break;
                        }
                    }
                    if (!modificado) {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 6:

                    System.out.print("Ingrese ISBN del libro a eliminar: ");
                    String isbnEliminar = sc.nextLine();
                    boolean eliminado = listaLibros.removeIf(l -> l.getIsbn().equals(isbnEliminar));
                    if (eliminado) {
                        System.out.println("Libro eliminado.");
                    } else {
                        System.out.println("No se encontró un libro con ese ISBN.");
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
