package xyz.ruhshan.processor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import xyz.ruhshan.common.reqres.UserRegistrationRequest;

@Service
@Slf4j
public class UserRegistrationListener {
    private final RabbitTemplate rabbitTemplate;

    public UserRegistrationListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = {"q.user-registration"})
    public void onUserRegistration(UserRegistrationRequest event)  {
        log.info("User Registration Event Received: {}", event);

        executeRegistration(event);


        rabbitTemplate.convertAndSend("x.post-registration","", event);
    }

    private void executeRegistration(UserRegistrationRequest event) {
        log.info("Executing User Registration Event: {}", event);

        throw new RuntimeException("Registration Failed");

    }
}
