package pl.bemowski.football.data.api.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Check all is all files are available. If not download all files.
 * If all files are available then just download file from last year.
 */
public class FootballDataChecker implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(FootballDataChecker.class);

    private int i = 0;

    @Override
    public void run() {
        LOGGER.debug("check new files" + i++);
        final FilesChecker filesChecker = new FilesChecker();
        filesChecker.checkIsAllFilesAvailable();
    }

}
