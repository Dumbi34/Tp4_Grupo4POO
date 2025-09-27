package ar.edu.unju.escmi.tp4.ejercicio4;

public class Cliente {
    private int dni;
    private String nombre;
    private String tipoCliente;

    public Cliente (int dni, String nombre, String tipoCliente){
        this.dni = dni;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void mostrarDatos(){
        System.out.println("----------------------------------");
        System.out.println("DNI: "+ dni);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Tipo de cliente: "+ tipoCliente);
    }

}