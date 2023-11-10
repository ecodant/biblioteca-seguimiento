package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Biblioteca implements Prestamo {
    private Collection<Libro>listaLibros;
    private Collection<Cliente>listaClientes;
    private Collection<PrestamoRegistro>prestamoRegistros;
    private Collection<Libro>librosPrestados;

public Biblioteca(Collection<Libro>listaLibros,Collection<Cliente>listaClientes,Collection<PrestamoRegistro>prestamoRegistros){
    this.listaLibros=listaLibros;
    this.listaClientes=listaClientes;
    this.prestamoRegistros=prestamoRegistros;
}
// metodos get
public Collection<Libro> getListaLibros() {
    return listaLibros;
}

public Collection<Cliente> getListaClientes() {
    return listaClientes;
}

public Collection<PrestamoRegistro> getPrestamoRegistros() {
    return prestamoRegistros;
}
public Collection<Libro>getLibrosPrestados(){
    return librosPrestados;
}
//metodos para buscar un libro por titulo o por autor
public Optional<Libro> buscarLibroTitulo(Libro libro){
    Predicate<Libro> tituloIgual= l->l.getTitulo().equals(libro.getTitulo());
    return listaLibros.stream().filter(tituloIgual).findAny();
}
public Optional<Libro> buscarLibroAutor(String autor){
    Predicate<Libro> autorIgual= l->l.getAutor().equals(autor);
    return listaLibros.stream().filter(autorIgual).findAny();
}
//metodo que valida si el libro que ponga el usuario ya existe
private void validarLibroExiste(Libro libro){
    boolean libroExiste= buscarLibroTitulo(libro).isPresent();
    ASSERTION.assertion(!libroExiste,"el libro que desea registrar ya existe");
}
//metodo para registrar un libro si no existe
public void registrarLibro(Libro libro){
    validarLibroExiste(libro);
    listaLibros.add(libro);
}
//metodo para buscar un cliente en la lista de clientes de la biblioteca
public Optional<Cliente> buscarCliente(Cliente cliente){
Predicate<Cliente> clienteIgual=c->c.equals(cliente);
return listaClientes.stream().filter(clienteIgual).findAny();
}
//metodo que valida si el cliente que ponga el usuario ya existe 
private void validarClienteExiste (Cliente cliente){
    boolean clienteExiste= buscarCliente(cliente).isPresent();
    ASSERTION.assertion(!clienteExiste,"el cliente que desea registrar ya existe.");
}
//metodo que registra un cliente si no existe
public void registrarCliente(Cliente cliente){
    validarClienteExiste(cliente);
    listaClientes.add(cliente);
}
//metodo para buscar un prestamo en la lista de prestamo Registros
public Optional<PrestamoRegistro> buscarPrestamo(PrestamoRegistro prestamoRegistro){
    Predicate<PrestamoRegistro> mismoLibro= r->r.getLibro().equals(prestamoRegistro.getLibro());
    Predicate<PrestamoRegistro> mismoCliente= r->r.getCliente().equals(prestamoRegistro.getCliente());
    Predicate<PrestamoRegistro> mismaFecha= r->r.getFechaPrestamo().equals(prestamoRegistro.getFechaPrestamo());
    return prestamoRegistros.stream().filter(mismoLibro.and(mismoCliente).and(mismaFecha)).findAny();
}
//metodo para validar si el prestamo existe o no en la lista prestamo Registros
private void validarPrestamoExiste(PrestamoRegistro prestamoRegistro){
    boolean prestamoExiste=buscarPrestamo(prestamoRegistro).isPresent();
    ASSERTION.assertion(!prestamoExiste,"el prestamo que desea registrar ya existe");
}
//metodo para registrar un prestamo en la lista de prestamoRegistros y la lista de prestamos del cliente 
public void registrarPrestamo(PrestamoRegistro prestamoRegistro){
    validarPrestamoExiste(prestamoRegistro);
    prestamoRegistros.add(prestamoRegistro);
    prestamoRegistro.getCliente().registrarPrestamoCliente(prestamoRegistro);
}
//método prestar libro, realiza una transferencia del libro que pertenece al objeto prestamoRegistro, de la lista de libros (disponibles) 
//a la lista de libros prestados.
@Override
public void prestarLibro(PrestamoRegistro prestamoRegistro) {
   validarLibroExiste(prestamoRegistro.getLibro());
   librosPrestados.add(prestamoRegistro.getLibro());
   listaLibros.remove(prestamoRegistro.getLibro());
}
//método devolver libro, realiza el proceso contrario del método anterior
@Override
public void devolverLibro(PrestamoRegistro prestamoRegistro) {
   validarLibroExiste(prestamoRegistro.getLibro());
   listaLibros.add(prestamoRegistro.getLibro());
   librosPrestados.remove(prestamoRegistro.getLibro());
}
//método para buscar un prestamo en la coleccion de prestamoRegistros que coincida con ciertas condiciones para posteriormente 
//modificar su fecha de devolucion por la fecha actual.
public void buscarPrestamoRegistro(Libro libro, LocalDate fechaPrestamo) {
    Predicate<PrestamoRegistro> libroIgual = l -> l.getLibro().equals(libro);
    Predicate<PrestamoRegistro> fechaIgual = f -> f.getFechaPrestamo().equals(fechaPrestamo);
    Optional<PrestamoRegistro> iteracion = prestamoRegistros.stream().filter(libroIgual.and(fechaIgual)).findAny();
    iteracion.ifPresent(prestamoRegistro -> prestamoRegistro.setFechaDevolucion(LocalDate.now()));
}
// método para crear una lista que contenga la cantidad de prestamos de un mismo libro.
public Collection<PrestamoRegistro> generarInformePrestamos(Libro libro){
    Predicate<PrestamoRegistro> condicion= p->p.getLibro().equals(libro);
    return prestamoRegistros.stream().filter(condicion).collect(Collectors.toList());
}
}
