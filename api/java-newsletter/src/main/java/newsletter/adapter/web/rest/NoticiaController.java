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

import newsletter.application.service.NoticiaService;
import newsletter.domain.model.Noticia;

@RestController
@RequestMapping("/noticia")
public class NoticiaController {

	@Autowired
	private NoticiaService noticiaService;

	@GetMapping
	public List<Noticia> getAllNoticias() {
		return noticiaService.getAllNoticias();
	}

	@GetMapping("/{id}")
	public Noticia getNoticiaById(@PathVariable Long id) {
		return noticiaService.getNoticiaById(id);
	}

	@PostMapping
	public Noticia createNoticia(@RequestBody Noticia noticia) {
		return noticiaService.createNoticia(noticia);
	}

	@PutMapping("/{id}")
	public Noticia updateNoticia(@PathVariable Long id, @RequestBody Noticia noticia) {
		return noticiaService.updateNoticia(id, noticia);
	}

	@DeleteMapping("/{id}")
	public void deleteNoticia(@PathVariable Long id) {
		noticiaService.deleteNoticia(id);
	}
}
