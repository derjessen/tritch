package com.torben.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hauke on 15.07.16.
 */
@Entity
@Table(
        name = "tblgame"
)
public class Game implements Serializable {
    @NotNull
    private int id;
    private String gameName;
    private int twitchId;
    private List<GameStats> gameStats;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "game"
    )
    public List<GameStats> getGameStats() {
        return gameStats;
    }

    @Column(
            name = "gamename"
    )
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Column(
            name = "twitch_id"
    )
    public int getTwitchId() {
        return twitchId;
    }

    public void setTwitchId(int twitchId) {
        this.twitchId = twitchId;
    }

    public void setGameStats(List<GameStats> gameStats) {
        this.gameStats = gameStats;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tblgame_id_game_seq")
    @SequenceGenerator(name="tblgame_id_game_seq", sequenceName="tblgame_id_game_seq", allocationSize=1)
    @Column(
            name = "id_game",
            nullable = false,
            unique = true
    )
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
