package com.torben.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by hauke on 15.07.16.
 */
@Entity
@Table(
        name = "tblgamestats"
)
public class GameStats {
    private Game game;
    private LocalDateTime measuringTime;
    private int viewer;
    private int channels;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "fk_game",
            nullable = false,
            insertable = false,
            updatable = false
    )
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public LocalDateTime getMeasuringTime() {
        return measuringTime;
    }

    public void setMeasuringTime(LocalDateTime measuringTime) {
        this.measuringTime = measuringTime;
    }

    public int getViewer() {
        return viewer;
    }

    public void setViewer(int viewer) {
        this.viewer = viewer;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }
}
