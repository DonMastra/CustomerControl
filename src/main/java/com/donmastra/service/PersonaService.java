package com.donmastra.service;

import com.donmastra.domain.Persona;
import java.util.List;

/**
 *
 * @author DonMastra
 */
public interface PersonaService {
    
    public List<Persona> listarPersonas();
    
    public void guardarPersona(Persona persona);
    
    public void eliminarPersona(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
    
}
