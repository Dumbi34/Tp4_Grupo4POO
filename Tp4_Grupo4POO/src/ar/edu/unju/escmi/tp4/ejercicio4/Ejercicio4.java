package ar.edu.unju.escmi.tp4.ejercicio4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio4 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Set<Cliente> clientes = new HashSet<>();
        char opcion;

        do{
            System.out.println("");
            System.out.println("---------------------------------");
            System.out.println("** MENU **");
            System.out.println("1- Crear cliente");
            System.out.println("2- Mostrar los datos de un cliente");
            System.out.println("3- Mostrar todos los clientes");
            System.out.println("4- Mostrar todos los clientes ocasionales y la cantidad");
            System.out.println("5- Mostrar todos los clientes frecuentes y la cantidad");
            System.out.println("6- Salir");
            System.out.print("- Elegir opcion: ");
            opcion = sc.nextLine().charAt(0);
            System.out.println("");

            switch (opcion) {
                case '1':
                    System.out.print("Ingrese DNI: ");
                    int dni = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Ingrese el nombre: ");
                    String nombre = sc.nextLine();

                    String tipoCliente;
                    System.out.println("Elegir el tipo de cliente: ");
                    System.out.println("Ingrese 1 o F para seleccionar cliente frecuente");
                    System.out.println("Ingrese 2 u O para seleccionar cliente ocasional");
                    System.out.println("Ingrese 3 u otro boton para asignar uno personalizado");
                    switch (sc.nextLine()) {
                        case "1":
                        case "F":
                        case "f":
                            tipoCliente = "frecuente";
                            break;
                    
                        case "2":
                        case "O":
                        case "o":
                            tipoCliente = "ocasional";
                            break;

                        default:
                            System.out.print("- ");
                            tipoCliente = sc.nextLine();
                            break;
                    }
                    System.out.println("Tipo de cliente: "+ tipoCliente);

                    Cliente cliente = new Cliente(dni,nombre,tipoCliente);

                    if(clientes.add(cliente)){
                        System.out.println("La persona con el dni "+ cliente.getDni()+ " fue agregado correctamente");
                    }
                    break;

            
                case '2':
                    if(clientes.isEmpty()){
                        System.out.println("No hay ningun cliente registrado");
                    }else{
                        System.out.println("Ingrese el DNI del cliente");
                        int clienteBuscar = sc.nextInt();
                        sc.nextLine();
                        
                        boolean encontrado = false;
                        for(Cliente e : clientes){
                            if(e.getDni() == clienteBuscar){
                                System.out.println("Los datos del cliente: ");
                                e.mostrarDatos();
                                encontrado = true;
                                break;
                            }
                        }

                        if(!encontrado){
                            System.out.println("No se encontro el DNI");
                        }

                    }
                    break;
 
                case '3':
                    if(clientes.isEmpty()){
                        System.out.println("No hay ningun cliente registrado");
                       }else{
                        clientes.stream().forEach(e -> e.mostrarDatos());
                    }
                    break;
                        
                case '4':
                        clientes.stream().filter(e -> e.getTipoCliente().equals("ocasional")).forEach(e -> e.mostrarDatos());
                        System.out.println("Cantidad: "+ clientes.stream().filter(e -> e.getTipoCliente().equals("ocasional")).count());
                    break;
                
                case '5':
                    clientes.stream().filter(e -> e.getTipoCliente().equals("frecuente")).forEach(e -> e.mostrarDatos());
                    System.out.println("Cantidad: "+ clientes.stream().filter(e -> e.getTipoCliente().equals("frecuente")).count());
                    break;

                case '6':
                        System.out.println("Saliendo...");
                    break;
 
                default:
                        System.out.println("Opcion no valida");
                    break;
            }

        }while( opcion != '6');

        sc.close();
    }
}