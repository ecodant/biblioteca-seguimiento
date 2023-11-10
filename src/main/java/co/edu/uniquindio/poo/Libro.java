package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Libro {
    private String titulo;
    private String autor;
    private byte numEjemplares;

public Libro(String titulo,String autor,byte numEjemplares){
    ASSERTION.assertion(titulo!=null,"el titulo del libro es requerido.");
    ASSERTION.assertion(autor!=null,"el autor del libro es requerido.");
    ASSERTION.assertion(numEjemplares>=0,"el numero de ejemplares no puede ser negativo.");
    this.titulo=titulo;
    this.autor=autor;
    this.numEjemplares=numEjemplares;
}

public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public String getAutor() {
    return autor;
}

public void setAutor(String autor) {
    this.autor = autor;
}

public byte getNumEjemplares() {
    return numEjemplares;
}

public void setNumEjemplares(byte numEjemplares) {
    this.numEjemplares = numEjemplares;
}

}
