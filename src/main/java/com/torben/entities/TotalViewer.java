package com.torben.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by hauke on 15.07.16.
 */
@Entity
@Table(
        name = "tbltotalviewer"
)
public class TotalViewer {
    private LocalDateTime measuringTime;
    private int viewer;
    private int channels;

    @GeneratedValue
    @Column(
            name = "measuringtime"
    )
    public LocalDateTime getMeasuringTime() {
        return measuringTime;
    }

    public void setMeasuringTime(LocalDateTime measuringTime) {
        this.measuringTime = measuringTime;
    }

    @GeneratedValue
    @Column(
            name = "viewer"
    )
    public int getViewer() {
        return viewer;
    }

    public void setViewer(int viewer) {
        this.viewer = viewer;
    }

    @GeneratedValue
    @Column(
            name = "channels"
    )
    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }
}
