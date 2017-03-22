package pl.bemowski.football.data.api.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by kamil on 19.02.17.
 */
class FootballApi {
    private static final Logger LOGGER = LogManager.getLogger(FootballApi.class);
    private ThreadPoolExecutor threadPool;

    static FootballApi start() {
        LOGGER.info("Football Api has started.");
        final FootballApi instance = FootballApiHolder.INSTANCE;
        instance.runThread(FootballApiThreads.instance());
        return instance;
    }

    private void runThread(final FootballApiThreads threads) {
        threads.schedule(new FootballDataChecker(), 1, TimeUnit.SECONDS);
    }


    private static class FootballApiHolder {
        private static final FootballApi INSTANCE = new FootballApi();
    }
}
