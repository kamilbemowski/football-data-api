package pl.bemowski.football.data.api.mapper.csv;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
class CSVHeader {
    private Map<String, Integer> valuePositionMap = new HashMap<>();

    CSVHeader(String line) {
        List<String> split = Arrays.asList(line.split(","));
        for (int i = 0; i < split.size(); i++) {
            String value = split.get(i);
            valuePositionMap.put(value, i);
        }
    }

    Integer getPosition(String value) {
        return valuePositionMap.get(value);
    }

    public int size() {
        return valuePositionMap.size();
    }
}
