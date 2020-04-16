package pl.bemowski.football.data.api.mapper.csv;

import lombok.extern.log4j.Log4j2;
import pl.bemowski.football.data.api.mapper.utils.StringUtils;
import pl.bemowski.football.data.api.model.Result;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
@Log4j2
public class CSVRecord {

    private CSVHeader header;
    private Map<Integer, String> positionValueMap = new HashMap<>();
    private DateTimeFormatter pattern =
            new DateTimeFormatterBuilder().appendPattern("dd/MM/")
                    .appendValueReduced(
                            ChronoField.YEAR, 2, 4, Year.now().getValue() - 80
                    ).toFormatter();

    CSVRecord(String line, CSVHeader csvHeader) {
        int i = 0;
        log.trace("Read line: " + line);
        String[] words = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        for (String o : words) {
            positionValueMap.put(i++, o.replace("\"", ""));
        }
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
            try {
                return Double.parseDouble(stringValue);
            } catch (NumberFormatException e) {
                log.info("cannot read field: " + value);
                return null;
            }
        }
        return null;
    }

    public int getHeaderSize() {
        return header.size();
    }

    public String line() {
        return String.join(", ", positionValueMap.values());
    }

    public String getString(String first, String second) {
        return Optional.ofNullable(getString(first)).orElse(getString(second));
    }
}
