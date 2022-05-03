package com.ly.musix;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.track.Track;

import java.util.ArrayList;
import java.util.List;

public class MusixHandler {

    public static void main(String[] args) {
        String apiKey = "";
        MusixMatch musixMatch = new MusixMatch(apiKey);
        MusixHandler musixHandler =  new MusixHandler();

        List<Track> verifiedResults = new ArrayList<>();

        try {
            List<Track> tracks = musixMatch.searchTracks("", "Eminem", "", 10, 10, true);
            System.out.println(tracks.size());

            for (Track track:tracks) {
                //Get Album data...
                musixHandler.getAlbumData(track.getTrack().getAlbumId(), musixMatch);

            }

        } catch (MusixMatchException e) {
            e.printStackTrace();
        }

    }

    private void getAlbumData(Integer albumId, MusixMatch musixMatch) {
        String responseString = musixMatch.getAlbumData(albumId);
    }


}
