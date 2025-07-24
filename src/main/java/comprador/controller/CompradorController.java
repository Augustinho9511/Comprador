package comprador.controller;


import comprador.service.CompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CompradorController {

    @Value("${rabbitmq.payment}")
    private String payment;

    @Autowired
    private CompradorService compradorService;

    @PostMapping("/comprador/text")
    public void compradorText(@RequestBody String text) {
        System.out.println("Mensagem" + text);
        compradorService.compradorTextMessage(text, payment);

    }
}
