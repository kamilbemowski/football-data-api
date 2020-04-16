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
public class CSVRecordListReader extends Flowable<List<Record>> {

    private static final Logger LOGGER = LogManager.getLogger(CSVRecordListReader.class);

    private final RecordMapper mapper;
    private final Map<String, FilePackage> files;

    public CSVRecordListReader(Map<String, FilePackage> files) {
        this.files = files;
        mapper = RecordMapper.createRecordMapper();
    }

    @Override
    protected void subscribeActual(Subscriber<? super List<Record>> subscriber) {
        subscriber.onSubscribe(new RecordListSubscriber(files, subscriber));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mapper", mapper)
                .toString();
    }
}
