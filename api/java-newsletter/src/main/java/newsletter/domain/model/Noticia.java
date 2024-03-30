package newsletter.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "noticia")
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titulo", length = 256, nullable = false)
	private String titulo;

	@Column(name = "descricao", length = 1000, nullable = false)
	private String descricao;

	@Column(name = "link", length = 256, nullable = false)
	private String link;

	@Column(name = "envio_realizado", nullable = false)
	private Boolean envioRealizado = false;

	public Noticia() {
	}

	public Noticia(String titulo, String descricao, String link, Boolean envioRealizado) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.link = link;
		this.envioRealizado = envioRealizado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Boolean getEnvioRealizado() {
		return envioRealizado;
	}

	public void setEnvioRealizado(Boolean envioRealizado) {
		this.envioRealizado = envioRealizado;
	}

}
