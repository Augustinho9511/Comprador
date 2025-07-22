package comprador.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class compradorService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void compradorTextMessage(String message, String venda) {
        System.out.println(message);
        rabbitTemplate.convertAndSend(venda, message);
    }
}
