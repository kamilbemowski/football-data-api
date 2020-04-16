package pl.bemowski.football.data.api.main;

import java.io.File;
import java.util.Optional;

import pl.bemowski.football.data.api.downloader.FootballFileNames;

/**
 * Created by kamil on 19.02.17.
 */
public class FilesChecker {
    public boolean checkIsAllFilesAvailable() {
        FootballFileNames fileNames = FootballFileNames.instance();
        Optional<String> lastFile = fileNames.last();
        File file = new File(lastFile.orElse("") + ".zip");
        return file.exists();
    }
}
