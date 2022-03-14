package mx.edu.utez.dwpu1evaluacion.service;

import mx.edu.utez.dwpu1evaluacion.model.Caracter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaracterServiceImpl implements CaracterService{

    private List<Caracter> caracterList;

    public CaracterServiceImpl() {
      caracterList = new ArrayList<>();
      caracterList.add(new Caracter(1,"Activo"));
      caracterList.add(new Caracter(2,"Independiente"));
      caracterList.add(new Caracter(3,"Juguetón"));
      caracterList.add(new Caracter(4,"Protector"));
      caracterList.add(new Caracter(5,"Ruidoso"));
      caracterList.add(new Caracter(6,"Tímido"));
      caracterList.add(new Caracter(7,"Tranquilo"));
      caracterList.add(new Caracter(8,"Amoroso"));
    }

    @Override
    public List<Caracter> listarTodos() {
        return caracterList;
    }


}
