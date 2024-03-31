package newsletter.adapter.web.rest;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import newsletter.application.service.MailService;

@RestController
@RequestMapping("/email")
public class MailController {
	ResourceBundle resourceBundle = ResourceBundle.getBundle("MessagesBundle_pt");
	
	@Autowired
	private MailService mailService;
	
	@GetMapping("/enviar_noticias_diarias")
	public ResponseEntity<String> enviarNoticiasDiarias() {
		try {
			mailService.enviarEmailDiario();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resourceBundle.getString("mensagem_erro_envio") + e.getMessage());
		} 
		
		return ResponseEntity.ok(resourceBundle.getString("mensagem_sucesso_envio"));
	}
}
