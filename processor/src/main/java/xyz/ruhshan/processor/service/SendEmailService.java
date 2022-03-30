package xyz.ruhshan.processor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import xyz.ruhshan.common.reqres.UserRegistrationRequest;

@Service
@Slf4j
public class SendEmailService {

    @RabbitListener(queues = "q.send-email")
    public void sendEmail(UserRegistrationRequest request) {
        log.info("Sending email to {}", request.getEmail());
    }
}
