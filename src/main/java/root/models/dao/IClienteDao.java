package root.models.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import root.models.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{

    @Query("SELECT c FROM Cliente c LEFT JOIN FETCH c.facturas f WHERE c.id=?1")
    Cliente fetchByIdWithFacturas(Long id);
	
}
