package pl.bemowski.football.data.api.main;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * Created by kamil on 19.02.17.
 */
public class FilesChecker {
    public void checkIsAllFilesAvailable() {
        File files = FileUtils.getFile(new File(this.getClass().getClassLoader().getResource("") + "csv/"));
        for (File file : files.listFiles()) {

        }

    }
}
