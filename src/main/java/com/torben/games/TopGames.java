package com.torben.games;

import com.mb3364.http.RequestParams;
import com.mb3364.twitch.api.Twitch;
import com.mb3364.twitch.api.handlers.TopGamesResponseHandler;
import com.mb3364.twitch.api.models.TopGame;
import com.torben.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopGames {

    private Twitch twitch;
    private final GameRepository gameRepository;

    @Autowired
    public TopGames(Twitch twitch, GameRepository gameRepository) {
        this.twitch = twitch;
        this.gameRepository = gameRepository;
    }
    @Scheduled(fixedRate = 20000)
    public void getTopGames() {
        RequestParams params = new RequestParams();
        params.put("limit", 1);

        twitch.games().getTop(params, new TopGamesResponseHandler() {

            @Override
            public void onSuccess(int i, List<TopGame> list) {
                
                System.out.println(list.size());
                for (TopGame game : list) {
                    Game myGame = new Game();
                    myGame.setGameName(game.getGame().getName()); 
                    myGame.setTwitchId(((int) game.getGame().getId()));
                    gameRepository.save(myGame);
                    System.out.println(game.getGame().getName() + " hat " + game.getViewers() + " Zuschauer");
                }
            }

            @Override
            public void onFailure(int i, String s, String s1) {

            }

            @Override
            public void onFailure(Throwable throwable) {
            }
        });
    }
}
