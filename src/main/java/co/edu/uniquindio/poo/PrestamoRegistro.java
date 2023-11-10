package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.time.LocalDate;

public class PrestamoRegistro{
    private Libro libro;
    private Cliente cliente;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

public PrestamoRegistro(Libro libro,Cliente cliente,LocalDate fechaPrestamo){
    ASSERTION.assertion(libro!=null,"el libro no puede ser nulo.");
    ASSERTION.assertion(cliente!=null,"el cliente no puede ser nulo.");
    ASSERTION.assertion(fechaPrestamo!=null,"la fecha del prestamo no puede ser nula");
    this.libro=libro;
    this.cliente=cliente;
    this.fechaPrestamo=fechaPrestamo;
}

public Libro getLibro() {
    return libro;
}

public void setLibro(Libro libro) {
    this.libro = libro;
}

public Cliente getCliente() {
    return cliente;
}

public void setCliente(Cliente cliente) {
    this.cliente = cliente;
}

public LocalDate getFechaPrestamo() {
    return fechaPrestamo;
}

public void setFechaPrestamo(LocalDate fechaPrestamo) {
    this.fechaPrestamo = fechaPrestamo;
}
public LocalDate getFechaDevolucion() {
    return fechaDevolucion;
}

public void setFechaDevolucion(LocalDate fechaDevolucion) {
    this.fechaDevolucion = fechaDevolucion;
}

}
