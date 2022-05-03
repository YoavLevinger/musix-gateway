package org.jmusixmatch.entity.album;

import com.google.gson.annotations.SerializedName;

public class Body {
    @SerializedName("album")
    Album AlbumObject;


    // Getter Methods

    public Album getAlbum() {
        return AlbumObject;
    }

    // Setter Methods

    public void setAlbum(Album albumObject) {
        this.AlbumObject = albumObject;
    }
}
