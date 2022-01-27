package domain;

public class Pelicula {
    //Atributos
    private String nombre;
    
    //Constructor
    public Pelicula(){
        
    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
}
