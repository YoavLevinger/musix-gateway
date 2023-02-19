package com.ly.utils;

import com.opencsv.CSVWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvHandler {

    static final Logger logger = LogManager.getLogger();

    private CsvHandler() {}

    /**
     * Write CSV file with default , separator, given data in the following format:
     * data.add(new String[] { "Name", "Class", "Marks" });
     * data.add(new String[] { "Yigal", "10", "999" });
     * @param filePath e.g.: %work.dir%/foo/results.csv
     * @param data first line could be header
     */
    public static void writeDataToCsvFile(String filePath, List<String[]> data)
    {
        File file = new File(filePath);
        try (FileWriter outputFile = new FileWriter(file); CSVWriter writer = new CSVWriter(outputFile);) {
            writer.writeAll(data);
        } catch (IOException e) {
            logger.error("Failed to write CSV file [{}]", e.getMessage(), e);
        }
    }

}
