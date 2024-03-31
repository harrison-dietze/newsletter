package newsletter.application.service;

import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import newsletter.domain.model.Cliente;
import newsletter.domain.model.Noticia;

@Service
public class MailService {
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private NoticiaService noticiaService;
	
    @Autowired
    private JavaMailSender javaMailSender;
    
    ResourceBundle resourceBundle = ResourceBundle.getBundle("MessagesBundle_pt");

    @Scheduled(cron = "0 0 8 * * *") // https://en.wikipedia.org/wiki/Cron
    public void enviarEmailDiario() throws Exception {
    	List<Noticia> noticias = noticiaService.getPendentes();
    	
    	if (noticias.isEmpty()) {
            throw new Exception(resourceBundle.getString("mensagem_erro_nao_ha_noticias_pendentes"));
        }
    	
    	List<Cliente> clientes = clienteService.getAllClientes();
    	
    	if (clientes.isEmpty()) {
            throw new Exception(resourceBundle.getString("mensagem_erro_nao_ha_clientes"));
        }

    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
  	    MimeMessageHelper helper;
  	    helper = new MimeMessageHelper(mimeMessage, false);
    	
  	    String assuntoEmail = resourceBundle.getString("email_titulo_noticias");
  	    
    	String corpoEmailInicio =  resourceBundle.getString("html_boilerplate_inicio");
    	String corpoEmailFim =  resourceBundle.getString("html_boilerplate_fim");
    	String corpoEmailNoticias = montarCorpoEmailNoticias(noticias);
    	
    	helper.setSubject(assuntoEmail);
    	
    	clientes.forEach(cliente -> {
    		String corpoEmailDestinatario = resourceBundle.getString("email_corpo_bom_dia_destinatario").replace("{destinatario}", cliente.getNome());
    		
    		if(cliente.isAniversariante()) {
    			corpoEmailDestinatario += resourceBundle.getString("email_corpo_aniversariante");
    		}
    		
    		corpoEmailDestinatario += resourceBundle.getString("email_corpo_segue_as_noticias");
    		
    		enviarEmailDestinatario(cliente, helper, mimeMessage, corpoEmailInicio + corpoEmailDestinatario + corpoEmailNoticias + corpoEmailFim);
    	});
    	
    	System.out.println("E-mails enviados!");
        return;
		
    }

    private String montarCorpoEmailNoticias(List<Noticia> noticias) {  
    	String resultadoHTML = "";
    	for (Noticia noticia : noticias) {
			
    		String textoNoticia = "<br/><a href=\"{link}\">{titulo}</a>"
					  			  .replace("{titulo}", noticia.getTitulo())
					  			  .replace("{link}", noticia.getLink())
					  
					  			+ "<p>{descricao}<p><br/>"
					  			  .replace("{descricao}", noticia.getDescricao());
    		
    		resultadoHTML += textoNoticia;
		}
    
        return resultadoHTML;
    }
    
    private void enviarEmailDestinatario(Cliente cliente, MimeMessageHelper helper, MimeMessage message, String body) {
    	try {
    		helper.setFrom(new InternetAddress("java_newsletter@email.com", "Java Newsletter"));
    		helper.setText(body, true);
			helper.setTo(cliente.getEmail());
			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
