package root.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import root.models.entity.Factura;

/**
 * IFacturaDao
 */
public interface IFacturaDao extends CrudRepository<Factura, Long>{

    @Query("SELECT f FROM Factura f JOIN FETCH f.cliente c JOIN FETCH f.items l JOIN FETCH l.producto WHERE f.id=?1")
    Factura fetchByIdWithClienteWithItemFacturaWithProducto(Long id);
    
}