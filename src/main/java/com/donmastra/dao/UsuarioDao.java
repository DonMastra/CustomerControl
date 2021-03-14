package com.donmastra.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.donmastra.domain.Usuario;
/**
 *
 * @author DonMastra
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
    Usuario findByUsername(String username);
    
}
