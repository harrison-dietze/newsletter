package newsletter.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import newsletter.domain.model.Noticia;
import newsletter.domain.repository.NoticiaRepository;

import java.util.List;

@Service
public class NoticiaService {
	@Autowired
	private NoticiaRepository noticiaRepository;

	public List<Noticia> getAllNoticias() {
		return noticiaRepository.findAll();
	}

	public Noticia getNoticiaById(Long id) {
		return noticiaRepository.findById(id).orElse(null);
	}

	public Noticia createNoticia(Noticia noticia) {
		return noticiaRepository.save(noticia);
	}

	public Noticia updateNoticia(Long id, Noticia noticia) {
		if (noticiaRepository.existsById(id)) {
			noticia.setId(id);
			return noticiaRepository.save(noticia);
		}
		return null;
	}

	public void deleteNoticia(Long id) {
		noticiaRepository.deleteById(id);
	}
}
