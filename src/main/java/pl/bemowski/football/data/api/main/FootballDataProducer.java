package pl.bemowski.football.data.api.main;

import com.google.common.collect.Multimap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bemowski.football.data.api.downloader.CSVRecordReader;
import pl.bemowski.football.data.api.model.FilePackage;
import pl.bemowski.football.data.api.model.Record;

import java.util.Map;

/**
 * Check all is all process are available. If not download all process.
 * If all process are available then just download file from last year.
 */
public class FootballDataProducer {

    private static final Logger LOGGER = LogManager.getLogger(FootballDataProducer.class);

    private int i = 0;
    private final Map<String, FilePackage> valueMap;

    public FootballDataProducer(Map<String, FilePackage> valueMap) {
        this.valueMap = valueMap;
    }


    public Multimap<String, Record> call() {
        LOGGER.debug("check new process" + i++);
        long start = System.currentTimeMillis();
        CSVRecordReader csvRecordReader = new CSVRecordReader(valueMap);
        Multimap<String, Record> records = csvRecordReader.readCSVFiles();
        LOGGER.info("FIles downloaded " + records.size() + " time: " + ((System.currentTimeMillis() - start) / 1000));
        return records;
    }

}
