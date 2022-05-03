package org.jmusixmatch.entity.album;

import com.google.gson.annotations.SerializedName;

public class AlbumMessageWrapper {
    @SerializedName("message")
    Message MessageObject;


    // Getter Methods

    public Message getMessage() {
        return MessageObject;
    }

    // Setter Methods

    public void setMessage(Message messageObject) {
        this.MessageObject = messageObject;
    }
}
