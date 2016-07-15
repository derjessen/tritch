package com.torben.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by hauke on 15.07.16.
 */
@Entity
@Table(
        name = "tbltotalviewer"
)
public class TotalViewer {
    private int id;
    private LocalDateTime measuringTime;
    private int viewer;
    private int channels;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tbltotalviewer_id_toatlviewer_seq")
    @SequenceGenerator(name="tbltotalviewer_id_toatlviewer_seq", sequenceName="tbltotalviewer_id_toatlviewer_seq", allocationSize=1)
    @Column(
            name = "id_totalviewer",
            nullable = false,
            unique = true
    )
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(
            name = "measuringtime"
    )
    public LocalDateTime getMeasuringTime() {
        return measuringTime;
    }

    public void setMeasuringTime(LocalDateTime measuringTime) {
        this.measuringTime = measuringTime;
    }

    @Column(
            name = "viewer"
    )
    public int getViewer() {
        return viewer;
    }

    public void setViewer(int viewer) {
        this.viewer = viewer;
    }

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
