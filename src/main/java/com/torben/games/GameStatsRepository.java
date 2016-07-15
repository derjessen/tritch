package com.torben.games;

import com.torben.entities.GameStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hauke on 15.07.16.
 */
@Repository
@Transactional
public interface GameStatsRepository extends JpaRepository<GameStats, Integer> {

}
