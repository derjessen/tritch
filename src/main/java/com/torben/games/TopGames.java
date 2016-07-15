package com.torben.games;

import com.mb3364.http.RequestParams;
import com.mb3364.twitch.api.Twitch;
import com.mb3364.twitch.api.handlers.TopGamesResponseHandler;
import com.mb3364.twitch.api.models.TopGame;
import com.torben.entities.GameStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopGames {

    private Twitch twitch;
    private final GameRepository gameRepository;
    private final GameStatsRepository gameStatsRepository;

    @Autowired
    public TopGames(Twitch twitch, GameRepository gameRepository, GameStatsRepository gameStatsRepository) {
        this.twitch = twitch;
        this.gameRepository = gameRepository;
        this.gameStatsRepository = gameStatsRepository;
    }
    @Scheduled(fixedRate = 20000)
    public void getTopGames() {
        RequestParams params = new RequestParams();
        params.put("limit", 5);

        twitch.games().getTop(params, new TopGamesResponseHandler() {

            @Override
            public void onSuccess(int i, List<TopGame> list) {
                
                System.out.println(list.size());
                for (TopGame game : list) {
                    GameStats gs = gameStatsRepository.findOne(4);
                    System.out.println(gs.getGame().getGameName());


//                    LocalDateTime now = LocalDateTime.now();
//
//                    Timestamp ts = new Timestamp(now.getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
//                    Game myGame = new Game();
//                    GameStats gamestats = new GameStats();
//                    int twitchId = (int)game.getGame().getId();
//
//                    if(gameRepository.existsByTwitchId(twitchId)) {
//                        myGame = gameRepository.findByTwitchId(twitchId);
//                    }else{
//                        myGame.setGameName(game.getGame().getName());
//                        myGame.setTwitchId((int) game.getGame().getId());
//                        gameRepository.save(myGame);
//                        myGame = gameRepository.findByTwitchId(twitchId);
//                    }
//
//
//                    gamestats.setChannels(game.getChannels());
//                    gamestats.setViewer(game.getViewers());
//                    gamestats.setGame(myGame);
//                    gamestats.setMeasuringTime(ts);
//
//                    gameStatsRepository.save(gamestats);
//
//                    System.out.println(game.getGame().getName() + " hat " + game.getViewers() + " Zuschauer");
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
