package newsletter.domain.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", length = 256, nullable = false)
	private String nome;

	@Column(name = "email", length = 256, nullable = false, unique = true)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Cliente() {
	}

	public Cliente(String nome, String email, LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	
	public Boolean isAniversariante() {
		LocalDate data = this.getDataNascimento();
		if(this.getDataNascimento() == null) return false;
		
		LocalDate hoje = LocalDate.now();
		
	    return hoje.getDayOfMonth() == data.getDayOfMonth() && data.getMonthValue() == hoje.getMonthValue();
	}

}
