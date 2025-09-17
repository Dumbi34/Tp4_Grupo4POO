package ar.edu.unju.escmi.tp4.ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio2 {
    
    public static void main(String[] args) {
        HashMap<String, Empleado> empleados = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n=====& MENÚ DE OPCIONES &=====");
            System.out.println("1- Alta de empleado");
            System.out.println("2- Mostrar empleados");
            System.out.println("3- Eliminar empleado");
            System.out.println("4- Consultar empleado");
            System.out.println("5- Salir");
            System.out.print("Ingresá la opción elegida: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // limpiar bufferr

            switch (opcion) {
                case 1:
                    System.out.print("Ingresea tu DNI: ");
                
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese sueldo: ");
                    double sueldo = scanner.nextDouble();
                    System.out.print("Ingrese categoría (letra): ");
                    char categoria = scanner.next().charAt(0);
                    scanner.nextLine(); // limpiar buffer

                    String clave = dni + categoria;
                    Empleado nuevo = new Empleado(dni, nombre, apellido, sueldo, categoria);
                    empleados.put(clave, nuevo);
                    System.out.println("Empleado agregado correctamente.");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE EMPLEADOS ---");
                    if (empleados.isEmpty()) {
                        System.out.println("No hay empleados cargados.");
                    } else {
                        Iterator<String> it = empleados.keySet().iterator();
                        while (it.hasNext()) {
                            String key = it.next();
                            System.out.println("Clave: " + key + " -> " + empleados.get(key));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingresá la clave del empleado a eliminar: ");
                    String claveEliminar = scanner.nextLine();
                    if (empleados.containsKey(claveEliminar)) {
                        empleados.remove(claveEliminar);
                        System.out.println("Empleado eliminado.");
                    } else {
                        System.out.println("No existe ningún empleado con esa clave.");
                    }
                    break;

                case 4:
                    System.out.print("Ingresá la clave a consultar: ");

                    String claveBuscar = scanner.nextLine();

                    if (empleados.containsKey(claveBuscar)) {
                        System.out.println("Empleado encontrado: " + empleados.get(claveBuscar));
                    } else {
                        System.out.println("No existe ningún empleado con esa clave.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
//ejercicio 2
