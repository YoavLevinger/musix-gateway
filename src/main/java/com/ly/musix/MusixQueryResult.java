package com.ly.musix;

public class MusixQueryResult {

    String songName;
    String performerName;
    String albumName;
    String songShareURL;


    public MusixQueryResult(String songName, String performerName, String albumName, String songShareURL) {
        this.songName = songName;
        this.performerName = performerName;
        this.albumName = albumName;
        this.songShareURL = songShareURL;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSongShareURL() {
        return songShareURL;
    }

    public void setSongShareURL(String songShareURL) {
        this.songShareURL = songShareURL;
    }

    @Override
    public String toString() {
        return "MusixQueryResult{" +
                "songName='" + songName + '\'' +
                ", performerName='" + performerName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", songShareURL='" + songShareURL + '\'' +
                '}';
    }

}
