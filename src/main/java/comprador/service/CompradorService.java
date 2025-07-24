package comprador.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompradorService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void compradorTextMessage(String message, String payment) {
        System.out.println(message);
        rabbitTemplate.convertAndSend(payment, message);
    }
}
