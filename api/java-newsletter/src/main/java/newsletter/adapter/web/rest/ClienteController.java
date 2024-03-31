package newsletter.adapter.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import newsletter.application.service.ClienteService;
import newsletter.domain.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> getAllClientes() {
		return clienteService.getAllClientes();
	}
	
	@GetMapping("/{id}")
	public Cliente getClienteById(@PathVariable Long id) {
		return clienteService.getClienteById(id);
	}

	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteService.createCliente(cliente);
	}

	@PutMapping("/{id}")
	public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		return clienteService.updateCliente(id, cliente);
	}

	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Long id) {
		clienteService.deleteCliente(id);
	}
}
