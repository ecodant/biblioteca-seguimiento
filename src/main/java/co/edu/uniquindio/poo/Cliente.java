package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.util.ArrayList;
import java.util.Collection;

public class Cliente extends Persona {
    private int numero;
    private Collection<PrestamoRegistro>listaPrestamosClientes;
//Constructor sin lista de prestamos
public Cliente(String nombre,String apellido,byte edad,int numero){
    super(nombre, apellido, edad);
    ASSERTION.assertion(numero>=0,"el numero de cliente no puede ser negativo.");
    this.numero=numero;
    this.listaPrestamosClientes=new ArrayList<>();
} 
// Constructor que recibe a la lista de prestamos ya creada
public Cliente(String nombre,String apellido,byte edad,int numero,Collection<PrestamoRegistro>listaPrestamosClientes){
    super(nombre, apellido, edad);
    ASSERTION.assertion(numero>=0,"el numero de cliente no puede ser negativo.");
    ASSERTION.assertion(listaPrestamosClientes!=null && listaPrestamosClientes.size()>0,"la lista de prestamos no puede ser nula ni estar vacia.");
    this.numero=numero;
    this.listaPrestamosClientes=listaPrestamosClientes;
}
public int getNumero() {
    return numero;
}
public void setNumero(int numero) {
    this.numero = numero;
}
public Collection<PrestamoRegistro> getListaPrestamosClientes() {
    return listaPrestamosClientes;
}
public void setPrestamos(Collection<PrestamoRegistro> listaPrestamosClientes) {
    this.listaPrestamosClientes = listaPrestamosClientes;
}
public void registrarPrestamoCliente(PrestamoRegistro prestamoRegistro){
    listaPrestamosClientes.add(prestamoRegistro);
}
}
