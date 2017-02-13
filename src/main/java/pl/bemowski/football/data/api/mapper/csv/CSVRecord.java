package pl.bemowski.football.data.api.mapper.csv;

import org.springframework.util.StringUtils;
import pl.bemowski.football.data.api.model.Result;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
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
    private DateTimeFormatter pattern =
            new DateTimeFormatterBuilder().appendPattern("dd/MM/")
                    .appendValueReduced(
                            ChronoField.YEAR, 2, 4, Year.now().getValue() - 80
                    ).toFormatter();

    CSVRecord(String line, CSVHeader csvHeader) {
        List<String> values = Arrays.asList(line.split(""));
        String word = "";
        int i = 0;
        String separator = "";
        boolean endWord = false;
        for (String sign : values) {
            if (sign.equals(",") && (separator.equals(",") || separator.equals(""))) {
                endWord = true;
                separator = sign;
            } else if (sign.equals("\"") && separator.equals("\"")) {
                endWord = true;
                separator = "";
            } else if (sign.equals("\"")) {
                separator = sign;
            } else {
                word += sign;
            }

            if (endWord && (!sign.equals(separator) || !word.isEmpty())) {
                positionValueMap.put(i++, word);
                word = "";
                endWord = false;
                continue;
            }
            endWord = false;
        }
        positionValueMap.put(i, word);
        this.header = csvHeader;

    }

    public String getString(String value) {
        Integer position = header.getPosition(value);
        return positionValueMap.get(position);
    }

    public Integer getInteger(String value) {
        String stringValue = getString(value);
        if (!StringUtils.isEmpty(stringValue)) {
            return Integer.valueOf(stringValue);
        } else {
            return null;
        }
    }

    public LocalDate getLocalDate(String value) {
        String string = getString(value);
        return LocalDate.parse(string, pattern);
    }

    public Result getResult(String value) {
        String stringValue = getString(value);
        if (!StringUtils.isEmpty(stringValue)) {
            return Result.valueOf(stringValue);
        } else {
            return null;
        }
    }

    public Double getDouble(String value) {
        String stringValue = getString(value);
        if (!StringUtils.isEmpty(stringValue)) {
            return Double.parseDouble(stringValue);
        }
        return null;
    }
}
