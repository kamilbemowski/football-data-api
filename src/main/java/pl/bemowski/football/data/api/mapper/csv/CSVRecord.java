package pl.bemowski.football.data.api.mapper.csv;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
public class CSVRecord {

    private CSVHeader header;
    private Map<Integer, String> positionValueMap = new HashMap<>();

    CSVRecord(String line, CSVHeader csvHeader) {
        List<String> values = Arrays.asList(line.split(","));
        for (int i = 0; i < values.size(); i++) {
            String value = values.get(i);
            positionValueMap.put(i, value);
        }
        this.header = csvHeader;

    }

    public String getString(String value) {
        Integer position = header.getPosition(value);
        return positionValueMap.get(position);
    }

    public int getInteger(String value) {
        return Integer.valueOf(getString(value));
    }

    public LocalDate getLocalDate(String value) {
        return LocalDate.parse(getString(value), DateTimeFormatter.ofPattern("dd/MM/yy"));
    }
}
