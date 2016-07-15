package com.torben;

import com.mb3364.twitch.api.Twitch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TritchApplication {

    public static void main(String[] args) {
        SpringApplication.run(TritchApplication.class, args);

    }

    @Bean
    public Twitch getTwitch(){
        Twitch twitch = new Twitch();
        // Register my application
        twitch.setClientId("pf07c0exdacmspfs21hro97tfpq0u6y");
        return twitch;
    }
}
