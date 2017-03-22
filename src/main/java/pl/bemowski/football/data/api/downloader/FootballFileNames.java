package pl.bemowski.football.data.api.downloader;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by Kamil Bemowski on 2017-03-03.
 */
public class FootballFileNames {
    private static final FootballFileNames INSTANCE = new FootballFileNames();
    private int endYear = LocalDateTime.now().getYear();
    private List<String> list = generate(endYear);

    void forEach(Consumer<? super String> consumer) {
        int currentYear = LocalDateTime.now().getYear();
        if (currentYear != endYear) {
            generate(endYear);
        }
        list.forEach(consumer);
    }

    private List<String> generate(int endYear) {
        list = new ArrayList<>();
        int startYear = 1993;
        for (int i = startYear; i <= endYear; i++) {
            int j = i + 1;
            String shortSeason = String.valueOf(i).substring(2) + String.valueOf(j).substring(2);
            list.add(shortSeason);
        }
        return list;
    }

    public static FootballFileNames instance() {
        return INSTANCE;
    }

    public Optional<String> last() {
        try {
            return Optional.ofNullable(list.get(list.size() - 1));
        } catch (final IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }
}
