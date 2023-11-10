package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Empleado extends Persona {
    private String cargo;

public Empleado(String nombre,String apellido,byte año,String cargo){
    super(nombre, apellido, año);
    ASSERTION.assertion(cargo!=null,"el cargo del empleado es requerido.");
    this.cargo=cargo;
}
public String getCargo(){
    return cargo;
}
}
