package mx.edu.utez.dwpu1evaluacion.controller;

import mx.edu.utez.dwpu1evaluacion.model.Caracter;
import mx.edu.utez.dwpu1evaluacion.model.Mascota;
import mx.edu.utez.dwpu1evaluacion.model.Person;
import mx.edu.utez.dwpu1evaluacion.service.CaracterService;
import mx.edu.utez.dwpu1evaluacion.service.CaracterServiceImpl;
import mx.edu.utez.dwpu1evaluacion.service.MascotaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/mascotas")
public class MacostaController {

    @Autowired
    private MascotaServiceImpl mascotaService;

    @Autowired
    private CaracterServiceImpl caracterService;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("persona", new Person());
        return "startPage";
    }

    @GetMapping("/tipoUsuario")
    public String user(@RequestParam("user") boolean user, Model model, Person person, BindingResult result) {
        if (!user) {
            model.addAttribute("userType", "admin");
            model.addAttribute("persona", person);
        }else{
            model.addAttribute("userType", "visit");
            model.addAttribute("persona", person);
        }
        return "index";
    }

    @GetMapping("/list/{tipo}")
    public String listarMascotas(@PathVariable("tipo") String tipo, Model model) {
        List<Mascota> mascotas = mascotaService.mascotasLista();
        List<Mascota> tipoAnimal = new ArrayList<>();

        switch (tipo) {
            case "Gato":
                for (Mascota m : mascotas) {
                    if (m.getTipoMascota().equals("Gato")) {
                        tipoAnimal.add(m);
                    }
                }
                model.addAttribute("mascotas", tipoAnimal);
                model.addAttribute("tipoMascota", "Gato");
                break;
            case "Perro":
                for (Mascota m : mascotas) {
                    if (m.getTipoMascota().equals("Perro")) {
                        tipoAnimal.add(m);
                    }
                }
                model.addAttribute("mascotas", tipoAnimal);
                model.addAttribute("tipoMascota", "Perro");
                break;
        }
        return "listMascotas";
    }

    @GetMapping("/create/{tipo}")
    public String createPert(Model model, @PathVariable("tipo") String tipo) {
        List<Caracter> caracterList = caracterService.listarTodos();
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("tipoMascota", tipo);
        model.addAttribute("listaCaracter",caracterList);
        return "formMascota";
    }

    @PostMapping("/save")
    public String savePet(@Valid @ModelAttribute("mascota") Mascota mascota, BindingResult result, Model model, RedirectAttributes attributes) {
        System.out.println(mascota.getCaracter().getId());
        if (result.hasErrors()) {
            List<Caracter> caracterList = caracterService.listarTodos();
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            model.addAttribute("listaCaracter",caracterList);
            model.addAttribute("tipoMascota", mascota.getTipoMascota());
            return "formMascota";
        } else {
            if (mascota.getTipoMascota().equals("Perro"))
                mascota.setImagen("perro1.jpg");
            else
                mascota.setImagen("gato1.jpg");
            mascotaService.guardar(mascota);
        }
        attributes.addFlashAttribute("valido","true");
        return "redirect:/mascotas/list/" + mascota.getTipoMascota() + "";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
