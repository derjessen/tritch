package com.torben.games;

import com.torben.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hauke on 15.07.16.
 */
@Repository
@Transactional
public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query("SELECT CASE WHEN COUNT(game.id) > 0 THEN 'true' ELSE 'false' END FROM Game game WHERE game.twitchId = ?1")
    boolean existsByTwitchId(int twitchId);

    Game findByTwitchId(int twitchId);
}
