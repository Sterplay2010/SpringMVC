package mx.edu.utez.dwpu1evaluacion.service;

import mx.edu.utez.dwpu1evaluacion.model.Caracter;
import mx.edu.utez.dwpu1evaluacion.model.Mascota;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService{
    private List<Mascota> mascotas;

    @Override
    public List<Mascota> mascotasLista() {
        return mascotas;
    }

    @Override
    public void guardar(Mascota mascota) {
        mascotas.add(mascota);
    }

    public MascotaServiceImpl(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Chop", 1, "Es el perro de GTA 5 XD", "Perro", "perro1.jpg", false));
        mascotas.add(new Mascota("Chino", 2, "Esta bonito", "Perro", "perro2.jpg", true));
        mascotas.add(new Mascota("Rikochet", 2, "No se, creo es el perro de mucha lucha", "Perro", "perro3.jpg", false));
        mascotas.add(new Mascota("Maau", 3, "Es el MAAU pero en perro ._.XD", "Perro", "perro4.jpg", true));
        //Gatos
        mascotas.add(new Mascota("El brincos", 1, "Es un gato que brinca mucho.", "Gato", "gato1.jpg", true));
        mascotas.add(new Mascota("Simon", 2, "Es un gato bonito.", "Gato", "gato2.jpg", false));
        mascotas.add(new Mascota("El Ramirez", 2, "ketachendo ramirez.", "Gato", "gato3.jpg", false));
        mascotas.add(new Mascota("Paleito", 1, "Es un gato normal", "Gato", "gato4.jpg", true));
    }


}
