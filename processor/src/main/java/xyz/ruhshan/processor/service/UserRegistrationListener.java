package xyz.ruhshan.processor.service;

import lombok.extern.slf4j.Slf4j;
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
    public void onUserRegistration(UserRegistrationRequest event) {
        log.info("User Registration Event Received: {}", event);

        rabbitTemplate.convertAndSend("x.post-registration",null, event);
    }
}
