package br.edu.uepb.example.secondmicroservice.consumers;


import br.edu.uepb.example.secondmicroservice.dtos.EmailDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.IOException;

public class GreetingsConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void consumer(@Payload EmailDTO emailDTO) {
        emailService.sendEmail(emailDTO);
        System.out.println("Email Status: SENT");
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void consumer(Message message) {
        try {
            EmailDTO emailDTO = new ObjectMapper().readValue(message.getBody(), EmailDTO.class);
            emailService.sendEmail(emailDTO);
            System.out.println("Email Status: SENT");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}