package br.edu.uepb.example.secondmicroservice.consumers;


import br.edu.uepb.example.secondmicroservice.dtos.EmailDTO;
import br.edu.uepb.example.secondmicroservice.models.EmailModel;
import br.edu.uepb.example.secondmicroservice.services.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.IOException;

public class GreetingsConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void consumer(@Payload EmailModel emailModel) {
        emailService.sendEmail(emailModel);
        System.out.println("Email Status: SENT");
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void consumer(Message message) {
        try {
            EmailModel emailModel = new ObjectMapper().readValue(message.getBody(), EmailModel.class);
            emailService.sendEmail(emailModel);
            System.out.println("Email Status: SENT");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}