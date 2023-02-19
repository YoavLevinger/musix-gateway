package com.ly.standalone;

import com.ly.musix.MusixHandler;
import com.ly.musix.MusixQueryResult;
import com.ly.utils.CsvHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class EntryPoint {

    String queryString = "car";
    String csvFileName = "results_<replace_me>.csv";
    String apiKey;
    List<MusixQueryResult> musixQueryResults;

    static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        EntryPoint entryPoint = new EntryPoint();
        //check input
        entryPoint.checkInput(args);
        //query by query string or by car if missing
        entryPoint.runQuery();
        //Save results in CSV file (song name, performer name, album name, song share URL)
        entryPoint.saveResultsToCsvFile();
    }

    private void checkInput(String[] args) {
        //check for api key
        if (args == null || args.length < 1) {
            logger.fatal("Missing Musix' API Key");
            System.exit(1);
        }
        apiKey = args[0];
        //check for query string, else set as "car"

        if (args.length > 1 && !args[1].isEmpty()) {
            queryString = args[1];
        } //else is already "car"...
    }

    private void runQuery() {
        MusixHandler musixHandler = new MusixHandler();
        musixQueryResults = musixHandler.getMusixQueryResults(apiKey, queryString);
    }

    private void saveResultsToCsvFile() {
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"song name", "performer name", "album name", "song share URL"});

        String queryStringNormalizedToFileName = queryString.replaceAll("[^\\w.-]", "_");

        for (MusixQueryResult musixQueryResult : musixQueryResults) {
            data.add(new String[]{
                    musixQueryResult.getSongName(),
                    musixQueryResult.getPerformerName(),
                    musixQueryResult.getAlbumName(),
                    musixQueryResult.getSongShareURL()});
        }
        CsvHandler.writeDataToCsvFile(csvFileName.replace("<replace_me>", queryStringNormalizedToFileName), data);
    }


}
