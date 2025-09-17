package ar.edu.unju.escmi.tp4.ejercicio2;
//ejercicio 2
public class Empleado {
    // Atributos
    private String dni;
    private String nombre;
    private String apellido;
    private double sueldo;
    private char categoria;

    // Constructor
    public Empleado(String dni, String nombre, String apellido, double sueldo, char categoria) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.categoria = categoria;
    }

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    // Método toString para mostrar datos en consola
    @Override
    public String toString() {
        return "Empleado{" +
                "DNI='" + dni + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Sueldo=" + sueldo +
                ", Categoría=" + categoria +
                '}';
    }
}
