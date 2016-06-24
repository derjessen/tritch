package com.torben.channels;

import com.mb3364.twitch.api.Twitch;
import com.mb3364.twitch.api.handlers.ChannelResponseHandler;

/**
 * Created by raGe on 14.06.2016.
 */
public class Channels {

    private Twitch twitch;
    private String username;

    public Channels(Twitch twitch, String username) {
        this.twitch = twitch;
        this.username = username;
    }

    public void channelFromUser(){
        twitch.channels().get(username, new ChannelResponseHandler() {
            @Override
            public void onSuccess(com.mb3364.twitch.api.models.Channel channel) {
                /* Successful response from the Twitch API */
                System.out.println(channel.getGame());
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                /* Twitch API responded with an error message */
            }

            @Override
            public void onFailure(Throwable e) {
                /* Unable to access Twitch, or error parsing the response */
            }
        });
    }
}
