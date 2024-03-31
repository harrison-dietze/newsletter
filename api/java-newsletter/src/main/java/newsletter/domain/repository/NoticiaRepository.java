package newsletter.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import newsletter.domain.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
	
	List<Noticia> findByEnvioRealizado(boolean envioRealizado);
}
