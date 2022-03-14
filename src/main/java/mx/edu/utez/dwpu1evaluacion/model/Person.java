package mx.edu.utez.dwpu1evaluacion.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Person {
    @NotBlank(message = "El campo no deberia estar vacio")
    @Size(min = 2,max = 50, message = "El campo no deberia contener un palabra con 2 o mas caracteres")
    private String nombre;
    @NotBlank(message = "El campo no deberia estar vacio")
    @Size(min = 2,max = 50, message = "El campo no deberia contener un palabra con 2 o mas caracteres")
    private String apellidos;
    @Email
    private String correo;

    public Person() {
    }

    public Person(String nombre, String apellidos, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
