package xyz.ruhshan.processor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import xyz.ruhshan.common.reqres.UserRegistrationRequest;

@Service
@Slf4j
public class FallBackRegistrationService {

    @RabbitListener(queues = {"q.fall-back-registration"})
    public void onRegistrationFailure(UserRegistrationRequest failedRegistration){
        log.info("Executing fallback for failed registration {}", failedRegistration);
    }

}
