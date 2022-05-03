package org.jmusixmatch.entity.album;

import com.google.gson.annotations.SerializedName;

public class Album {
    private float album_id;
    private String album_mbid;
    private String album_name;
    private float album_rating;
    private String album_release_date;
    private float artist_id;
    private String artist_name;
    @SerializedName("primary_genres")
    Primary_genres Primary_genresObject;
    private String album_pline;
    private String album_copyright;
    private String album_label;
    private float restricted;
    private String updated_time;
    @SerializedName("external_ids")
    External_ids External_idsObject;


    // Getter Methods

    public float getAlbum_id() {
        return album_id;
    }

    public String getAlbum_mbid() {
        return album_mbid;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public float getAlbum_rating() {
        return album_rating;
    }

    public String getAlbum_release_date() {
        return album_release_date;
    }

    public float getArtist_id() {
        return artist_id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public Primary_genres getPrimary_genres() {
        return Primary_genresObject;
    }

    public String getAlbum_pline() {
        return album_pline;
    }

    public String getAlbum_copyright() {
        return album_copyright;
    }

    public String getAlbum_label() {
        return album_label;
    }

    public float getRestricted() {
        return restricted;
    }

    public String getUpdated_time() {
        return updated_time;
    }

    public External_ids getExternal_ids() {
        return External_idsObject;
    }

    // Setter Methods

    public void setAlbum_id(float album_id) {
        this.album_id = album_id;
    }

    public void setAlbum_mbid(String album_mbid) {
        this.album_mbid = album_mbid;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public void setAlbum_rating(float album_rating) {
        this.album_rating = album_rating;
    }

    public void setAlbum_release_date(String album_release_date) {
        this.album_release_date = album_release_date;
    }

    public void setArtist_id(float artist_id) {
        this.artist_id = artist_id;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public void setPrimary_genres(Primary_genres primary_genresObject) {
        this.Primary_genresObject = primary_genresObject;
    }

    public void setAlbum_pline(String album_pline) {
        this.album_pline = album_pline;
    }

    public void setAlbum_copyright(String album_copyright) {
        this.album_copyright = album_copyright;
    }

    public void setAlbum_label(String album_label) {
        this.album_label = album_label;
    }

    public void setRestricted(float restricted) {
        this.restricted = restricted;
    }

    public void setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
    }

    public void setExternal_ids(External_ids external_idsObject) {
        this.External_idsObject = external_idsObject;
    }
}