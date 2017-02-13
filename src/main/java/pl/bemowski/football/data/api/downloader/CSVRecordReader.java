package pl.bemowski.football.data.api.downloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
@Component
public class CSVRecordReader {

    @Autowired
    private RecordMapper mapper;

    void readCSVFiles(Map<String, InputStream> files) throws IOException {
        files.forEach((fileName, file) -> {
            try (final Reader reader = new InputStreamReader(file, "UTF-8")) {
                final CSVParser parser = new CSVParser(reader);
                parser.getRecords().forEach(r -> mapper.map(r));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
