package pl.bemowski.football.data.api.downloader;

import lombok.extern.log4j.Log4j2;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import pl.bemowski.football.data.api.mapper.RecordMapper;
import pl.bemowski.football.data.api.mapper.csv.CSVParser;
import pl.bemowski.football.data.api.model.FilePackage;
import pl.bemowski.football.data.api.model.Record;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Log4j2
public class RecordSubscriber implements Subscription {
    private final Map<String, FilePackage> files;
    private final Subscriber<? super Record> subscriber;
    private RecordMapper mapper = RecordMapper.createRecordMapper();
    private final AtomicLong atomicLong = new AtomicLong(1);


    public RecordSubscriber(Map<String, FilePackage> files, Subscriber<? super Record> subscriber) {
        this.files = files;
        this.subscriber = subscriber;
    }

    @Override
    public void request(long l) {
        log.info("Parse files count: " + files.size());
        files.forEach((fileName, file) -> {
                    log.info("Parse file: " + fileName);
                    try {
                        InputStreamReader reader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);

                        try {
                            CSVParser parser = new CSVParser(reader);
                            parser.getRecords().parallelStream().forEach((csvRecord) -> {
                                Record record = this.mapper.mapToRecord(csvRecord, file.getSeason());
//                                log.info("Record parsed " + record);
                                atomicLong.getAndIncrement();
                                this.subscriber.onNext(record);
                            });
                        } catch (Throwable var7) {
                            try {
                                reader.close();
                            } catch (Throwable var6) {
                                var7.addSuppressed(var6);
                            }

                            throw var7;
                        }

                        reader.close();
                    } catch (IOException var8) {
                        log.error("Cannot read file", var8);
                    }
                }
        );
        log.info("Parsed records: " + atomicLong.get());
        subscriber.onComplete();
    }

    @Override
    public void cancel() {

    }
}
