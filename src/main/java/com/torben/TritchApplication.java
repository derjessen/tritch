package com.torben;

import com.mb3364.twitch.api.Twitch;
import com.torben.channels.Channels;
import com.torben.games.TopGames;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TritchApplication {

    private Twitch twitch;

    public static void main(String[] args) {
        SpringApplication.run(TritchApplication.class, args);

//        Channels by username
//        Channels chan = new Channels(twitch, "TV_raGe");
//        chan.channelFromUser();

    }

    @Bean
    public Twitch getTwitch(){
        Twitch twitch = new Twitch();
        // Register my application
        twitch.setClientId("pf07c0exdacmspfs21hro97tfpq0u6y");
        return twitch;
    }
}
