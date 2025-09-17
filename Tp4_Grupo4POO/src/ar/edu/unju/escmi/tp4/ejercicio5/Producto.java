package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;

public class Producto {

    private String descripcion;
    private double precio;
    private LocalDate fechaDeVencimiento;

    // Constructor para crear un objeto Producto
    public Producto(String descripcion, double precio, LocalDate fechaDeVencimiento) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    // Método toString() para mostrar la información del producto
    @Override
    public String toString() {
        return "Descripción: " + descripcion +
                ", Precio: " + precio +
                ", Vencimiento: " + fechaDeVencimiento;
    }
}