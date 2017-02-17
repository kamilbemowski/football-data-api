package pl.bemowski.football.data.api.downloader;

import pl.bemowski.football.data.api.mapper.RecordMapper;
import pl.bemowski.football.data.api.mapper.csv.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
public class CSVRecordReader {


    private final RecordMapper mapper;

    public CSVRecordReader() {
        mapper = new RecordMapper();
    }

    void readCSVFiles(Map<String, InputStream> files) throws IOException {
        files.forEach((fileName, file) -> {
            try (final Reader reader = new InputStreamReader(file, "UTF-8")) {
                final CSVParser parser = new CSVParser(reader);
                parser.getRecords().forEach(mapper::map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
