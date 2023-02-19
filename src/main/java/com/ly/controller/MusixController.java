package com.ly.controller;

import com.google.gson.Gson;
import com.ly.musix.MusixHandler;
import com.ly.musix.MusixQueryResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MusixController {

    static final Logger logger = LogManager.getLogger();
    public static String apiKey;

    @GetMapping("/musix-query")
    public String query(@RequestParam String queryString) {
        List<MusixQueryResult> musixQueryResults;
        MusixHandler musixHandler = new MusixHandler();
        //check input, if empty use "car"
        if (queryString==null || queryString.isEmpty())  {
            queryString = "car";
            logger.info("No query string sent, setting queryString as default \"car\"");
        } else {
            logger.info("QueryString sent: [{}]", queryString);
        }
        //run query, send results
        musixQueryResults = musixHandler.getMusixQueryResults(apiKey, queryString);

        return new Gson().toJson(musixQueryResults);
    }

    @GetMapping("/set-musix-api-key")
    public String setApiKey(@RequestParam String apiKey) {
        MusixController.apiKey = apiKey;
        String result = "API KEY wat set to [" + MusixController.apiKey + "]";
        logger.info(result);
        return result;
    }

}
