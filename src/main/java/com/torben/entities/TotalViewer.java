package com.torben.entities;

import java.time.LocalDateTime;

/**
 * Created by hauke on 15.07.16.
 */
public class TotalViewer {
    private LocalDateTime measuringTime;
    private int viewer;
    private int channels;

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
