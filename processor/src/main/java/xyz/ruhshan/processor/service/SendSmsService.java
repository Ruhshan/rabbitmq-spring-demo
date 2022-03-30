package xyz.ruhshan.processor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import xyz.ruhshan.common.reqres.UserRegistrationRequest;

@Service
@Slf4j
public class SendSmsService {
    @RabbitListener(queues = "q.send-sms")
    public void sendSms(UserRegistrationRequest request) {
        log.info("Sending sms to {} ", request.getMobileNumber());
    }
}
