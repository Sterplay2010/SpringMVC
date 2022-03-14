package mx.edu.utez.dwpu1evaluacion.model;


public class Caracter {

    private int id;
    private String nombre;

    public Caracter() {
    }

    public Caracter(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
