package pl.bemowski.football.data.api.downloader;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
class DownloadFiles {

    public static final String FOOTBALL_DATA_FILE_NAME = "/data.zip";
    private static final Logger LOGGER = LogManager.getLogger(DownloadFiles.class);
    public static final String FOOTBALL_DATA_URL = "http://www.football-data.co.uk/mmz4281/";
    private CSVRecordReader csvRecordReader;

    DownloadFiles(CSVRecordReader csvRecordReader) {
        this.csvRecordReader = csvRecordReader;
    }

    @PostConstruct
    public void init() {
        List<File> allZipPackages = getAllZipPackages();
        UnzipFiles unzipFiles = new UnzipFiles();
        Map<String, InputStream> valueMap = unzipFiles.unzipFiles(allZipPackages);
        try {
            csvRecordReader.readCSVFiles(valueMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<File> getAllZipPackages() {
        List<File> zipFiles = new ArrayList<>();
        final int startYear = 1993;
        final int endYear = LocalDateTime.now().getYear();
        for (int i = startYear; i <= endYear; i++) {
            final int j = i + 1;
            final String shortSeason = getSeasonShortName(new SeasonNameCreator(i, j));

            try {
                final File destination = new File(this.getClass().getClassLoader().getResource("/") + shortSeason + ".zip");
                final String zipUrl = FOOTBALL_DATA_URL + shortSeason + FOOTBALL_DATA_FILE_NAME;
                FileUtils.copyURLToFile(
                        new URL(zipUrl),
                        destination);
                zipFiles.add(destination);
            } catch (IOException e) {
                LOGGER.warn("Could not download file", e);
            }
        }
        return zipFiles;
    }

    private String getSeasonShortName(SeasonNameCreator seasonNameCreator) {
        return String.valueOf(seasonNameCreator.getI()).substring(2) + String.valueOf(seasonNameCreator.getJ()).substring(2);
    }
}
