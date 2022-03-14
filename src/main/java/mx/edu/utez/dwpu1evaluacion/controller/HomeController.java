package mx.edu.utez.dwpu1evaluacion.controller;

import mx.edu.utez.dwpu1evaluacion.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/contacto")
public class HomeController {

    @PostMapping("/informacion")
    public String enviarDatos(@Valid @ModelAttribute("persona") Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            model.addAttribute("userType","admin");
            return "index";
        } else {
            model.addAttribute("nombre", person.getNombre());
            model.addAttribute("apellido", person.getApellidos());
            model.addAttribute("correo", person.getCorreo());
            return "confirmContacto";
        }
    }
}
