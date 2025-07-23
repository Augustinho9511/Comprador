package comprador.controller;


import comprador.service.compradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class compradorController {

    @Value("${rabbitmq.compra}")
    private String compra;

    @Autowired
    private compradorService compradorService;

    @PostMapping("/comprador/text")
    public void compradorText(@RequestBody String text) {
        System.out.println("Mensagem" + text);
        compradorService.compradorTextMessage(text, compra);

    }
}
