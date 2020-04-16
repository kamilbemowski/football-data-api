package pl.bemowski.football.data.api.mapper.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
public class CSVParser {

    private List<CSVRecord> records = new ArrayList<>();

    public CSVParser(Reader inputReader) {
        BufferedReader reader = new BufferedReader(inputReader);
        String line;
        int i = 0;
        CSVHeader csvHeader = null;
        try {
            while ((line = reader.readLine()) != null) {
                if (i == 0) {
                    csvHeader = new CSVHeader(line);
                } else {
                    if (isNotEmpty(line)) {
                        records.add(new CSVRecord(line, csvHeader));
                    }
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isNotEmpty(String line) {
        return Arrays.stream(line.split(",")).anyMatch(l -> !l.isEmpty() && !l.equals("#REF!"));
    }

    public List<CSVRecord> getRecords() {
        return records;
    }
}
