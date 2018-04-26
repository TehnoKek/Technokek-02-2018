package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@SpringBootApplication
public class Main implements WebSocketMessageBrokerConfigurer {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }
}
