package pl.bemowski.football.data.api.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bemowski.football.data.api.model.FilePackage;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by kamil on 19.02.17.
 */
class FootballApi {
    private static final Logger LOGGER = LogManager.getLogger(FootballApi.class);
    private FootballDataProcessor footballDataProcessor = new FootballDataProcessor();
    static FootballApi start() {
        LOGGER.info("Football Api has started.");
        final FootballApi instance = FootballApiHolder.INSTANCE;
        instance.runSchedulers();
        return instance;
    }

    private void runSchedulers() {
        Map<String, FilePackage> process = footballDataProcessor.process();
        try {
            Executors.newFixedThreadPool(1).submit(() -> process).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


    private static class FootballApiHolder {
        private static final FootballApi INSTANCE = new FootballApi();
    }
}
