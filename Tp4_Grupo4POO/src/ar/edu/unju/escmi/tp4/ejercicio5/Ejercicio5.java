package ar.edu.unju.escmi.tp4.ejercicio5;
// ejercicio 5
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio5{

    public static void main(String[] args) {
        
        TreeMap<Integer, Producto> productos = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== &MENÚ DE OPCIONES& =====");

            System.out.println("1- Alta de producto");
            System.out.println("2- Mostrar productos");
            System.out.println("3- Buscar un producto");
            System.out.println("4- Eliminar un producto");
            System.out.println("5- Salir");
            System.out.print("Ingresá la opción elegida: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opción inválida. Ingresá un número.");
                scanner.nextLine();
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    // Alta de producto
                    System.out.print("Ingrese la clave (número entero) para el producto: ");
                    int clave = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    // Validar si la clave ya existe
                    if (productos.containsKey(clave)) {
                        System.out.println("Error: La clave ya existe. No se pudo agregar el producto.");
                    } else {
                        System.out.print("Ingrese la descripción del producto: ");
                        String descripcion = scanner.nextLine();
                        System.out.print("Ingrese el precio: ");
                        double precio = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer

                        System.out.print("Ingrese la fecha de vencimiento (formato dd/MM/yyyy): ");
                        String fechaString = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate fechaVencimiento = LocalDate.parse(fechaString, formatter);

                        Producto nuevoProducto = new Producto(descripcion, precio, fechaVencimiento);
                        productos.put(clave, nuevoProducto);
                        System.out.println("Producto agregado correctamente.");
                    }
                    break;

                case 2:
                    // Mostrar productos
                    System.out.println("\n--- LISTA DE PRODUCTOS ---");
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos cargados.");
                    } else {
                        Iterator<Integer> it = productos.keySet().iterator();
                        while (it.hasNext()) {
                            Integer key = it.next();
                            System.out.println("Clave: " + key + " -> " + productos.get(key));
                        }
                    }
                    break;

                case 3:
                    // Buscar un producto
                    System.out.print("Ingresá la clave del producto a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    if (productos.containsKey(claveBuscar)) {
                        System.out.println("Producto encontrado: " + productos.get(claveBuscar));
                    } else {
                        System.out.println("No existe un producto con esa clave.");
                    }
                    break;

                case 4:
                    // Eliminar un producto
                    System.out.print("Ingresá la clave del producto a eliminar: ");
                    int claveEliminar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    if (productos.containsKey(claveEliminar)) {
                        productos.remove(claveEliminar);
                        System.out.println("Producto eliminado correctamente.");
                    } else {
                        System.out.println("No existe un producto con esa clave.");
                    }
                    break;

                case 5:
                    // Salir
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, intentá de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
    
}