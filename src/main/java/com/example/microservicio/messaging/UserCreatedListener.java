package com.example.microservicio.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedListener {

    @RabbitListener(queues = "user.created.queue")
    public void handleUserCreated(String message) {

        System.out.println("Mensaje recibido: " + message);

        // lógica
    }


}