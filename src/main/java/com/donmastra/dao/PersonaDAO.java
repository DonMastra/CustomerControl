package com.donmastra.dao;

import com.donmastra.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author DonMastra
 */


public interface PersonaDAO extends JpaRepository<Persona, Long>{
    
}
