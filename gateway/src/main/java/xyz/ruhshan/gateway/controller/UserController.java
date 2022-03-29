package xyz.ruhshan.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ruhshan.common.reqres.ApiResponse;
import xyz.ruhshan.common.reqres.UserRegistrationRequest;


@Slf4j
@RestController
@RequestMapping(value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final RabbitTemplate rabbitTemplate;

    public UserController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/user")
    public ApiResponse createUser(@RequestBody UserRegistrationRequest request) {
        log.info("Received request to create user: {}", request);
        rabbitTemplate.convertAndSend("", "q.user-registration", request);
        return new ApiResponse("Ok");
    }
}
