package comprador.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class RabbitMQConfig {

    @Value("{rabbitmq.host}")
    private String host;

    @Value("{rabbitmq.user}")
    private String user;

    @Value("{rabbitmq.password}")
    private String password;

    @Value("{rabbitmq.port}")
    private int port;

    @Value("{rabbitmq.payment}")
    private String payment;


    @Bean
    public CachingConnectionFactory connectionFactory() throws Exception {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host);
        connectionFactory.setUsername(user);
        connectionFactory.setPassword(password);
        connectionFactory.setPort(8080);

        return connectionFactory();
    }

    public RabbitTemplate rabbitTemplate () throws Exception {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());

        return rabbitTemplate;
    }


}
