package newsletter.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import newsletter.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
