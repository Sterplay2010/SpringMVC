package mx.edu.utez.dwpu1evaluacion.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class Mascota {

    @NotBlank(message = "El campo no deberia estar vacio")
    private String nombre;
    @NotNull(message = "El campo no debe estar nulo")
    @Min(value = 1,message = "La edad debe ser mayor a 0")
    private Integer edad;
    @NotBlank(message = "El campo no deberia estar vacio")
    @Size(min = 2,max = 50, message = "El campo no deberia contener un palabra con 2 o mas caracteres")
    private String descripcion;
    private String tipoMascota;
    private Date fechaRegistro;
    private String imagen;
    private Boolean disponibleAdopcion;
    private Caracter caracter;

    public Mascota(String nombre, Integer edad, String descripcion, String tipoMascota, String imagen, Boolean disponibleAdopcion) {
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.tipoMascota = tipoMascota;
        this.imagen = imagen;
        this.disponibleAdopcion = disponibleAdopcion;
    }

    public Mascota(String nombre, Integer edad, String descripcion, String tipoMascota, Date fechaRegistro, String imagen, Boolean disponibleAdopcion, Caracter caracter) {
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.tipoMascota = tipoMascota;
        this.fechaRegistro = fechaRegistro;
        this.imagen = imagen;
        this.disponibleAdopcion = disponibleAdopcion;
        this.caracter = caracter;
    }

    public Mascota() {
    }


    public Boolean getDisponibleAdopcion() {
        return disponibleAdopcion;
    }

    public Caracter getCaracter() {
        return caracter;
    }

    public void setCaracter(Caracter caracter) {
        this.caracter = caracter;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean isDisponibleAdopcion() {
        return disponibleAdopcion;
    }

    public void setDisponibleAdopcion(Boolean disponibleAdopcion) {
        this.disponibleAdopcion = disponibleAdopcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", descripcion='" + descripcion + '\'' +
                ", tipoMascota='" + tipoMascota + '\'' +
                ", imagen='" + imagen + '\'' +
                ", disponibleAdopcion=" + disponibleAdopcion +
                '}';
    }
}
