package co.edu.uniquindio.poo;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private byte edad;

public Persona(String nombre,String apellido,byte edad){
    ASSERTION.assertion(nombre!=null,"el nombre de la persona es requerido.");
    ASSERTION.assertion(apellido!=null,"el apellido de la persona es requerido.");
    ASSERTION.assertion(edad>=0,"la edad de la persona no puede ser negativa.");
    this.nombre=nombre;
    this.apellido=apellido;
    this.edad=edad;
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

public byte getEdad() {
    return edad;
}

public void setEdad(byte edad) {
    this.edad = edad;
}

}