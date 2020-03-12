package root.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import root.models.entity.Cliente;
import root.models.entity.Factura;
import root.models.entity.Producto;

public interface IClienteService {

	List<Cliente> findAll();
	
	void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
	
	public Page<Cliente> findAll(Pageable page);

	public List<Producto> findByNombre(String term);

	public void saveFactura(Factura factura);

	public Producto findProductoById(Long id);

	public Factura findFacturaById(Long id);

	public void deleteFactura(Long id);

	Factura fetchByIdWithClienteWithItemFacturaWithProducto(Long id);

	Cliente fetchByIdWithFacturas(Long id);
	
}
