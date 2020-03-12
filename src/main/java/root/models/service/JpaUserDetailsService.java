package root.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import root.models.dao.IUsuarioDao;
import root.models.entity.Role;
import root.models.entity.Usuario;

/**
 * JpaUserDetailsService
 */
@Service(value = "jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioDao usuarioDao;

    private Logger log = LoggerFactory.getLogger(JpaUserDetailsService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario == null) {
            log.error("Error login: no existe el usuario '" + username + "' ");
            throw new UsernameNotFoundException("Username " + username + " no existe en el sistema");
        }
        

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role : usuario.getRoles()) {
            log.info("Role: " + role.getAuthority());
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        if (authorities.isEmpty()) {
            log.error("Error login: usuario '" + username + "' no tiene roles asignados");
            throw new UsernameNotFoundException("Error login: usuario '" + username + "' no tiene roles asignados");
        }

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
    }

    
    
}