package newsletter.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import newsletter.domain.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

}
