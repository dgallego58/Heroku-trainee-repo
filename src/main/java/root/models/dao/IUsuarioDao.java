package root.models.dao;

import org.springframework.data.repository.CrudRepository;

import root.models.entity.Usuario;

/**
 * IUsuarioDao
 */
public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}