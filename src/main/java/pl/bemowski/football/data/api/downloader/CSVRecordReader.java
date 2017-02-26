package pl.bemowski.football.data.api.downloader;

import com.google.common.base.MoreObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOGGER = LogManager.getLogger(CSVRecordReader.class);

    private final RecordMapper mapper;

    public CSVRecordReader() {
        mapper = RecordMapper.createRecordMapper();
    }

    void readCSVFiles(final Map<String, InputStream> files) throws IOException {
        files.forEach((fileName, file) -> {
            try (final Reader reader = new InputStreamReader(file, "UTF-8")) {
                final CSVParser parser = new CSVParser(reader);
                parser.getRecords().forEach(mapper::mapToRecord);
            } catch (final IOException e) {
                LOGGER.error("Cannot read file", e);
            }
        });

    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mapper", mapper)
                .toString();
    }
}
