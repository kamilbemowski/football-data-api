package pl.bemowski.football.data.api.downloader;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import io.reactivex.Flowable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reactivestreams.Subscriber;
import pl.bemowski.football.data.api.mapper.RecordMapper;
import pl.bemowski.football.data.api.mapper.csv.CSVParser;
import pl.bemowski.football.data.api.model.FilePackage;
import pl.bemowski.football.data.api.model.Record;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
public class CSVRecordReader extends Flowable<Record> {

    private static final Logger LOGGER = LogManager.getLogger(CSVRecordReader.class);

    private final RecordMapper mapper;
    private final Map<String, FilePackage> files;

    public CSVRecordReader(Map<String, FilePackage> files) {
        this.files = files;
        mapper = RecordMapper.createRecordMapper();
    }

    @Override
    protected void subscribeActual(Subscriber<? super Record> subscriber) {
        subscriber.onSubscribe(new RecordSubscriber(files, subscriber));
    }

    public Multimap<String, Record> readCSVFiles() {
        Multimap<String, Record> records = ArrayListMultimap.create();
        LOGGER.info("Parse files count: " + files.size());
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        files.forEach((fileName, file) -> {
            Future<List<Record>> future = executorService.submit(() -> {
                 LOGGER.info("Parse file: " + fileName);
                long start = System.currentTimeMillis();
                try (final Reader reader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8)) {
                    LOGGER.info("File readed in time: " + (System.currentTimeMillis() - start));
                    final CSVParser parser = new CSVParser(reader);
                    LOGGER.info("Records count: " + parser.getRecords().size() + " " + parser.getRecords().get(0).getHeaderSize());
                    long startStream = System.currentTimeMillis();
                    List<Record> recordList = parser.getRecords().stream().map(csvRecord -> {
                        long mapperStart = System.currentTimeMillis();
                        Record record = mapper.mapToRecord(csvRecord, file.getSeason());
                        LOGGER.debug("Record mapped in time: " + (System.currentTimeMillis() - mapperStart));
                        return record;
                    }).collect(Collectors.toList());
                    LOGGER.info("All records mapped in time: " + (System.currentTimeMillis() - startStream));
                    return recordList;
                } catch (final IOException e) {
                    LOGGER.error("Cannot read file", e);
                    return null;
                }
            });
            try {
                records.putAll(fileName, future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        return records;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mapper", mapper)
                .toString();
    }
}
