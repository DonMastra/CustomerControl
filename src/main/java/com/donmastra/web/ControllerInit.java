package com.donmastra.web;

import com.donmastra.dao.PersonaDAO;
import com.donmastra.domain.Persona;
import com.donmastra.service.PersonaService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author DonMastra
 */

@Controller
@Slf4j
public class ControllerInit {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    public String init(Model model, @AuthenticationPrincipal User user){
        var personas = personaService.listarPersonas();
        log.info("Ejecutando el controller Spring MVC");
        log.info("Usuario que hizo login: " + user);
        model.addAttribute("personas", personas);
        var saldoTotal = 0D;
        for(var persona : personas){
            saldoTotal += persona.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardarPersona(persona);
        return "redirect:/";
    }
    
    //Parameters with path variable
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    //Parameters with query params
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminarPersona(persona);
        return "redirect:/";
    }
}
