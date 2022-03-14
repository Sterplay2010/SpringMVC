package mx.edu.utez.dwpu1evaluacion.service;

import mx.edu.utez.dwpu1evaluacion.model.Mascota;

import java.util.ArrayList;
import java.util.List;

public interface MascotaService {
    List<Mascota> mascotasLista();
    void guardar(Mascota mascota);
}
