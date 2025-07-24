package comprador.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import comprador.modal.PaymentMessage;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


@Service
public class CompradorService {

    ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void compradorTextMessage(String message, String payment) {
        System.out.println(message);
        rabbitTemplate.convertAndSend(payment, message);
    }

    public void compradorJsonMessage(String message, String payment) {
        PaymentMessage msgObject = (PaymentMessage) jsonToObject(message, PaymentMessage.class);
        rabbitTemplate.convertAndSend(payment, objectToJNode(msgObject));
    }

    private JsonNode objectToJNode(Object jsonObject) {
        return objectMapper.valueToTree(jsonObject);
    }

    private Object jsonToObject(String jsonStrin, Class<?> clazz) {
        try {
            return objectMapper.readValue(jsonStrin, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    public void init() {
        objectMapper = new ObjectMapper();
    }
}
