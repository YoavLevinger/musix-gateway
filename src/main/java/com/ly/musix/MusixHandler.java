package com.ly.musix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.entity.album.AlbumMessageWrapper;
import org.jmusixmatch.entity.track.Track;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MusixHandler {

    static final Logger logger = LogManager.getLogger();

    public List<MusixQueryResult> getMusixQueryResults(String apiKey, String queryString) {
        List<MusixQueryResult> musixQueryResults;
        MusixMatch musixMatch = new MusixMatch(apiKey);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Track> jointTracks;

        jointTracks = searchTracks(queryString, musixMatch);

        musixQueryResults = filterResultsByAlbumReleaseDate(musixMatch, formatter, jointTracks);

        logger.info("Found [{}] matching records", musixQueryResults.size());

        return musixQueryResults;
    }

    private List<MusixQueryResult> filterResultsByAlbumReleaseDate(MusixMatch musixMatch, SimpleDateFormat formatter, List<Track> jointTracks) {
        AlbumMessageWrapper albumMessageWrapper;
        List<MusixQueryResult> musixQueryResults = new ArrayList<>();

        for (Track track : jointTracks) {

            albumMessageWrapper = musixMatch.getAlbumData(track.getTrack().getAlbumId());
            try {

                if (albumMessageWrapper != null
                        && albumMessageWrapper.getMessage().getBody().getAlbum().getAlbum_release_date() != null
                        && albumMessageWrapper.getMessage().getBody().getAlbum().getAlbum_release_date().before(formatter.parse("2010-01-01"))) {

                    logger.info("Adding result with release date [{}]", albumMessageWrapper.getMessage().getBody().getAlbum().getAlbum_release_date());
                    musixQueryResults.add(new MusixQueryResult(track.getTrack().getTrackName(),
                            track.getTrack().getArtistName(),
                            track.getTrack().getAlbumName(),
                            track.getTrack().getTrackShareUrl()));

                }

            } catch (Exception e) {
                logger.error("Failed to retrieve Album details [{}]", e.getMessage(), e);
            }
        }
        return musixQueryResults;
    }

    private List<Track> searchTracks(String queryString, MusixMatch musixMatch) {
        List<Track> tracks;
        List<Track> jointTracks = new ArrayList<>();
        int paginationCounter = 1;
        do {
            try {
                tracks = musixMatch.searchTracks("", queryString,"", "", paginationCounter, 100, true);
            } catch (Exception e) {
                if (jointTracks.isEmpty()) {
                    logger.error("No result found for search string [{}] or Exceeded daily quota for API Key / License ", queryString);
                } else {
                    logger.warn("Must have reached the last pagination page [{}] for search [{}]", paginationCounter, queryString);
                }
                break;
            }
            logger.info("Pagination result: received additional [{}] results for verification in page #[{}]", tracks.size(), paginationCounter);
            jointTracks.addAll(tracks);
            paginationCounter++;

        } while (!tracks.isEmpty());

        return jointTracks;
    }


}
