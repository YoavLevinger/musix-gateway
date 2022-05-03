package org.jmusixmatch.entity.album;

import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("header")
    Header HeaderObject;
    @SerializedName("body")
    Body BodyObject;


    // Getter Methods

    public Header getHeader() {
        return HeaderObject;
    }

    public Body getBody() {
        return BodyObject;
    }

    // Setter Methods

    public void setHeader(Header headerObject) {
        this.HeaderObject = headerObject;
    }

    public void setBody(Body bodyObject) {
        this.BodyObject = bodyObject;
    }
}